package day06;


import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie[] cookies=request.getCookies();
//		for (Cookie cookie : cookies) {
//			System.out.println(cookie.getName()+" "+URLDecoder.decode(cookie.getValue(),"utf-8"));
//		}
		
		
		String username=CookieUtil.findCookie("username", request);
		System.out.println(username);
		
		CookieUtil.modifyCookie("username", "abc", response);
		
		
		
	}
}
