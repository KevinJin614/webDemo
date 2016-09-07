package day02;


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

public class ShowModifyEmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得请求中的id值
		String id=request.getParameter("id");
		
		PrintWriter out=response.getWriter();
		
		//告诉容器，响应的结果是 text文本 html格式,字符编码是utf-8
		//以text/html;charset=utf-8传输给浏览器
		//浏览器以text/html解析数据，字符编码为utf-8,并打开
		response.setContentType("text/html;charset=utf-8");
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="root";
		
		//根据id查询一个员工的所有信息
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
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
//				根据查询出来的信息生成修改页面
//				out.println("<form action=\"/web/modify?id="+rs.getInt("id")+"\" method=\"post\">");
				out.println("<form action=\"/web/modify\" method=\"post\">");
				out.println("	<fieldset>");
				out.println("		<legend>Modify Emp</legend>");
				out.println("       <input type=\"hidden\" name=\"id\" value=\""+rs.getInt("id")+"\"/>");
				out.println("		name:<input type=\"text\" name=\"name\" value=\""+rs.getString("name")+"\"/><br/>");
				out.println("		salary:<input type=\"text\" name=\"salary\" value=\""+rs.getDouble("salary")+"\"/><br/>");
				out.println("		<input type=\"submit\" value=\"modify\"/>");
				out.println("	</fieldset>");
				out.println("</form>");

			}
			
			
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
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
			if(out!=null){
				out.close();
			}
		}
		
		
		
		
	}
}
