package day02;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectService...");
		System.out.println("insert into ....");
		//响应重定向
//		response.sendRedirect("/web/addEmp.html");
//		response.sendRedirect("http://127.0.0.1:8080/web/addEmp.html");
//		request.setAttribute("count", 564);
//		request.getSession().setAttribute("count", 555);
		response.sendRedirect(request.getContextPath()+"/count.jsp?count=555");
	}
}
