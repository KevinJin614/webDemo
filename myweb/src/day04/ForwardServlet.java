package day04;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("message", "aaaaaaaaaaaaa");
		System.out.println("insert into...");
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
	}
}
