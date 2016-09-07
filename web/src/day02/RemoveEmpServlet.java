package day02;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveEmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得请求中的id
		String id=request.getParameter("id");
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="root";
		//从数据库中根据id删除记录
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,username,password);
			
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("delete from t_emp ")
				.append("where id=? ")
				.toString();
				
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			
			ps.executeUpdate();
			
			con.commit();
			
//			response.sendRedirect("/web/list");
//			response.sendRedirect(request.getContextPath()+"/emp/findAll.jsp");
			response.sendRedirect(request.getContextPath()+"/findAll.emp");
			
		} catch (Exception e) {
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
