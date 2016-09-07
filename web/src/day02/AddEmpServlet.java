package day02;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class AddEmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//接收数据
		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		String sex=request.getParameter("sex");
		String edu=request.getParameter("edu");
		String[] hobbies=request.getParameterValues("hobbies");
		
		PrintWriter out=response.getWriter();
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="root";
		//将数据保存到数据库
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
				
			con=DriverManager.getConnection(url,username,password);
			
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("insert into t_emp ")
				.append("    (name,salary,sex,edu,hobbies) ")
				.append("values ")
				.append("    (?,?,?,?,?) ")
				.toString();
			
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, Double.parseDouble(salary));
			ps.setString(3, sex);
			ps.setString(4, edu);
			ps.setString(5, StringUtils.join(hobbies,","));
			ps.executeUpdate();
			
			con.commit();
//			out.println("<h1>add success</h1>");
//			response.sendRedirect(request.getContextPath()+"/emp/findAll.jsp");
			response.sendRedirect(request.getContextPath()+"/findAll.emp");
		} catch (Exception e) {
//			out.println("<h1>add fail</h1>");
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
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
}
