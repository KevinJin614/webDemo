package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JDBCUtil;
import util.JSONUtil;

public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=new User();
		try {
			con=JDBCUtil.getConnection();
			
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_user ")
				.append("where id=? ")
				.toString();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(id));
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		
		String json=JSONUtil.toJson(user);
		
		out.print(json);
		
		
	}
}
