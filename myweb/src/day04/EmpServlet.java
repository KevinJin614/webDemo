package day04;

import java.io.IOException;
import java.io.PrintWriter;
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

import org.apache.commons.lang.StringUtils;

public class EmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		if ("/findAll.emp".equals(path)) {
			findAll(request, response);
		} else if ("/showModify.emp".equals(path)) {
			showModify(request, response);
		} else if ("/add.emp".equals(path)) {
			add(request, response);
		} else if (path.startsWith("/remove.emp")) {
			remove(request, response);
		} else if ("/modify.emp".equals(path)) {
			modify(request, response);
		}
	}
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("id");
		
		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		String sex=request.getParameter("sex");
		String edu=request.getParameter("edu");
		String[] hobbies=request.getParameterValues("hobbies");
		
		
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="";
		
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,username,password);
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("update t_emp ")
				.append("set name=?, ")
				.append("    salary=?, ")
				.append("    sex=?, ")
				.append("    edu=?, ")
				.append("    hobbies=? ")
				.append("where id=? ")
				.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, Double.parseDouble(salary));
			ps.setString(3, sex);
			ps.setString(4, edu);
			ps.setString(5, StringUtils.join(hobbies,","));
			ps.setInt(6, Integer.parseInt(id));
			
			ps.executeUpdate();
			
			con.commit();
//			response.sendRedirect("/web/list");
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
	
	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得请求中的id
		String id=request.getParameter("id");
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="";
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
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 接收数据
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String sex = request.getParameter("sex");
		String edu = request.getParameter("edu");
		String[] hobbies = request.getParameterValues("hobbies");

		PrintWriter out = response.getWriter();

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "";
		// 将数据保存到数据库
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, username, password);

			con.setAutoCommit(false);

			String sql = new StringBuffer()
					.append("insert into t_emp ")
					.append("    (name,salary,sex,edu,hobbies) ")
					.append("	 values ")
					.append("    (?,?,?,?,?) ")
					.toString();

			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, Double.parseDouble(salary));
			ps.setString(3, sex);
			ps.setString(4, edu);
			ps.setString(5, StringUtils.join(hobbies, ","));

			ps.executeUpdate();

			con.commit();
			// out.println("<h1>add success</h1>");
			response.sendRedirect(request.getContextPath() + "/findAll.emp");
		} catch (Exception e) {
			// out.println("<h1>add fail</h1>");
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void showModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "";

		// 根据id查询一个员工的所有信息
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = new Emp();
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, username, password);

			con.setAutoCommit(false);

			String sql = new StringBuffer().append("select * ").append(
					"from t_emp ").append("where id=? ").toString();

			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));

			rs = ps.executeQuery();

			if (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setSex(rs.getString("sex"));
				emp.setEdu(rs.getString("edu"));
				// emp.setHobbies(rs.getString("hobbies").split(","));
				emp.setHob(rs.getString("hobbies"));
			}
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/emp/modify.jsp").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/emp/error.jsp");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "";
		String driver = "com.mysql.jdbc.Driver";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Emp> emps = new ArrayList<Emp>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

			String sql = new StringBuffer()
				.append("select * ")
				.append("from t_emp ")
				.toString();

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setSex(rs.getString("sex"));
				emp.setEdu(rs.getString("edu"));
				emp.setHobbies(rs.getString("hobbies").split(","));
				emps.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/emp/error.jsp");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// System.out.println(emps);
		request.setAttribute("emps", emps);
		request.getRequestDispatcher("/emp/findAll.jsp").forward(request,response);
	}

}
