package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateUsernameServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
		String username=request.getParameter("username");
		System.out.println(username);
		PrintWriter out=response.getWriter();
		if("abc".equals(username)){
			out.println("用户名已存在");
		}else{
			out.println("用户名可用");
		}
	}
}
