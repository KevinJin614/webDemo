package day06;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowLoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=CookieUtil.findCookie("username", request);
		String password=CookieUtil.findCookie("password", request);
		
		if(username==null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		if("abc".equals(username)&&"123".equals(password)){
			CookieUtil.addCookie("username", username, response);
			CookieUtil.addCookie("password", password, response);
			response.sendRedirect(request.getContextPath()+"/success.jsp");
			return;
		}
		
		CookieUtil.removeCookie("username", response);
		CookieUtil.removeCookie("password", response);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
