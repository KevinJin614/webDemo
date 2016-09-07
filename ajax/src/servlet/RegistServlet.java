package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("注册。。。");
		String username=request.getParameter("username");
		if("abc".equals(username)){
			request.setAttribute("message", "用户名已存在");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
