package day09;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletContextServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getServletContext方法由GenericServlet实现的
//		ServletContext application=getServletContext();
		ServletContext application=getServletConfig().getServletContext();
		String a=application.getInitParameter("a");
		System.out.println(a);
		
		System.out.println(application.getRealPath("/aaa/bbb"));
		
		
		
		
		
		
		
	}
}
