package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getRequestURI();
//		System.out.println(path);
		path=path.substring((request.getContextPath()+"/show").length());
		request.getRequestDispatcher("/WEB-INF"+path+".jsp").forward(request, response);
		
		
		
		
		
		
		
		
	}
}
