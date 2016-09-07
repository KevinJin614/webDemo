package servlet;


import java.io.IOException;
import java.io.PrintWriter;
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
import util.JSONUtil;

public class QueryServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key=request.getParameter("key");
		
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Result> results=new ArrayList<Result>();
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_result ")
				.append("where message like ? ")
				.append("or spell like ? ")
				.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1, key+"%");
			ps.setString(2, key+"%");
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				Result result=new Result();
				result.setMessage(rs.getString("message"));
				results.add(result);
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
		
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
		String json=JSONUtil.toJson(results);
		
		out.write(json);
		
		
	}
}
