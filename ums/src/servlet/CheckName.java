package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import exception.UserNotFoundException;
import factory.ObjectFactory;

import service.proxy.UserServiceProxy;
import util.JDBCUtil;

public class CheckName extends HttpServlet {
	private UserServiceProxy userService;
	public CheckName(){
		userService = (UserServiceProxy) ObjectFactory.getObject("userServiceProxy");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
		String path = request.getServletPath();
		System.out.println(path);
		String username = request.getParameter("username");
		System.out.println(username);
		PrintWriter out = response.getWriter();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			con.setAutoCommit(false);
			String sql = new StringBuffer()
				.append(" select * ")
				.append("from t_user ")
				.append("where username=? ")
				.toString();
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				out.print("用户名已注册");
				return;
			}
			out.print("用户名可用");
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		} finally {
			JDBCUtil.close();
			JDBCUtil.close(null, ps, rs);
		}
	}
}









