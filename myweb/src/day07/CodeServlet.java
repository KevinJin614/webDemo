package day07;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		if("/show.code".equals(path)){
			
		}
		if("/submit.code".equals(path)){
			
		}
	}
	private void show(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

	}
}
