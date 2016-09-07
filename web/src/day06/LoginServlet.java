package day06;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if("abc".equals(username)&&"123".equals(password)){
			
			CookieUtil.addCookie("username", username, response);
			CookieUtil.addCookie("password", password, response);
			
			request.getSession().setAttribute("user", username);
			response.sendRedirect(request.getContextPath()+"/success.jsp");
			return;
		}
		
		request.setAttribute("message", "用户名或密码错误");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
