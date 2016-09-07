package day01;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="root";
		//查询数据，查所有员工
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			con.setAutoCommit(false);
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_emp ")
				.toString();
			
			ps=con.prepareStatement(sql);
				
			rs=ps.executeQuery();
			
			out.println("<table border=\"1\">");
			out.println("	<tr>");
			out.println("		<th>id</th>");
			out.println("		<th>name</th>");
			out.println("		<th>salary</th>");
			out.println("       <th>operation</th>");
			out.println("	</tr>");
			

			while(rs.next()){
//				将数据通过response中的流以table形式发送给浏览器
				out.println("	<tr>");
				out.println("		<td>"+rs.getInt("id")+"</td>");
				out.println("		<td><a href='/web/load?id="+rs.getInt("id")+"'>"+rs.getString("name")+"</a></td>");
				out.println("		<td>"+rs.getDouble("salary")+"</td>");
				out.println("		<td><a href='/web/remove?id="+rs.getInt("id")+"' onclick='return confirm(\"Sure to remove the Employee?\")'>delete</a></td>");
				out.println("	</tr>");
			}
			out.println("</table>");
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
//			out.println("<h1>系统忙，稍后再试<h1>");
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
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
}
