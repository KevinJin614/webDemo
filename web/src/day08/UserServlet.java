package day08;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.JDBCUtil;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String path=request.getServletPath();
		if("/regist.user".equals(path)){
			regist(request, response);
		}
		if("/login.user".equals(path)){
			login(request, response);
		}
		if("/logout.user".equals(path)){
			logout(request, response);
		}
	}
	
	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收请求数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
			//根据用户名查询数据库，判断用户名是否存在
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_user ")
				.append("where username=? ")
				.toString();
			
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			
			rs=ps.executeQuery();
			
			//如果存在
			if(rs.next()){
				//设置错误消息
				request.setAttribute("message", "用户名已存在");
				
				con.commit();
				//转发到注册页面
				request.getRequestDispatcher("/shop/regist.jsp").forward(request, response);
				return;
			}
			
			//将数据保存到数据库
			sql=new StringBuffer()
				.append("insert into t_user ")
				.append("    (username,password,phone,address) ")
				.append("values ")
				.append("    (?,?,?,?) ")
				.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, phone);
			ps.setString(4, address);
			
			ps.executeUpdate();
			con.commit();
			//重定向到商品列表
			response.sendRedirect(request.getContextPath()+"/findAll.product");
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
		
	
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得请求数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
		
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
			//根据用户名和密码查询数据库
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_user ")
				.append("where username=? ")
				.append("and password=? ")
				.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			//如果找到记录
			if(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				
				//创建购物车对象
				Cart cart=new Cart();
			
				//放入session
				HttpSession session=request.getSession();
				session.setAttribute("cart", cart);
			
				//将查询到的用户对象放入session
				session.setAttribute("user", user);
				
				con.commit();
				//重定向到商品列表
				response.sendRedirect(request.getContextPath()+"/findAll.product");
				return;
			}
			
			//设置错误消息
			request.setAttribute("message", "用户名或密码错误");
			
			con.commit();
			
			//转发到登陆页面
			request.getRequestDispatcher("/shop/login.jsp").forward(request, response);
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
		
		
	}

	
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/findAll.product");
	}

	
	
	
	
	
	
}
