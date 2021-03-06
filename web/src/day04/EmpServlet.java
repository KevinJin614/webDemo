package day04;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		System.out.println(path);
		
		if("/findAll.emp".equals(path)){
			findAll(request, response);
		}
		if("/modify.emp".equals(path)){
			modify(request,response);
		}
		
	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="root";
		
		//根据id查询一个员工的所有信息
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Emp emp=new Emp();
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url, username,password);
			
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_emp ")
				.append("where id=? ")
				.toString();
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setSex(rs.getString("sex"));
				emp.setEdu(rs.getString("edu"));
				//emp.setHobbies(rs.getString("hobbies").split(","));
				emp.setHob(rs.getString("hobbies"));
			}
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/emp/modify2.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/emp/error.jsp");
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="root";	
		String driver="com.mysql.jdbc.Driver";
		
	
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Emp> emps=new ArrayList<Emp>();
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
			
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_emp ")
				.toString();
				
			ps=con.prepareStatement(sql);
				
			rs=ps.executeQuery();
			
			while(rs.next()){
				Emp emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emps.add(emp);
			}
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/emp/error.jsp");
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
//		System.out.println(emps);
		request.setAttribute("emps", emps);
		request.getRequestDispatcher("/emp/findAll.jsp").forward(request, response);
	}
	
	
	
	
}
