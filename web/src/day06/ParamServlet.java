package day06;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		String a=config.getInitParameter("a");
//		System.out.println(a);
//	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config=getServletConfig();
		
		String a=config.getInitParameter("a");
		
		System.out.println(a);
		
	}
}








