package day06;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(!"127.0.0.1".equals(request.getRemoteAddr())){
//			return;
//		}
		HttpSession session=request.getSession();
		String sessionId=session.getId();
		System.out.println(sessionId);
		
		
		Integer count=(Integer) session.getAttribute("count");
		if(count==null){
			count=1;
		}else{
			count++;
		}
		session.setAttribute("count", count);
		
		request.getRequestDispatcher("/count.jsp").forward(request, response);
	}
}
