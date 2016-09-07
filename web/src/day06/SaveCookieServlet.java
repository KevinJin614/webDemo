package day06;


import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username="啊啊啊";
//		username=URLEncoder.encode(username,"utf-8");
//		
//		System.out.println(username);
//		
//		Cookie cookie=new Cookie("username",username);
//		
//		
//		cookie.setPath("/web/a");
//		
//		cookie.setMaxAge(7*24*60*60);
//		
//		
//		String password="abc";
//		
//		Cookie cookie2=new Cookie("password",password);
//		
//		
//		response.addCookie(cookie);
//		response.addCookie(cookie2);
		
		CookieUtil.addCookie("username", "未确认", response);
		
		
		
		
		
		
		
		
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
