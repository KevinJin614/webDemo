package servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JDBCUtil;

public class ListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> users=new ArrayList<User>();
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_user ")
				.toString();
			
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				users.add(user);
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
			JDBCUtil.close(con, ps, rs);
		}
		
		
		request.setAttribute("users", users);
		
		request.getRequestDispatcher("/jQuery/list.jsp").forward(request, response);
		
		
		
		
		
	}
}
