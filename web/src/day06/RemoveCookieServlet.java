package day06;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie cookie=new Cookie("username","");
//		
//		cookie.setMaxAge(0);
//		
//		response.addCookie(cookie);
		
		CookieUtil.removeCookie("username", response);
	}
}
