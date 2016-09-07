package day03;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestRequestServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getMethod());
		//告诉容器，解析请求体中的数据使用UTF-8编码解析
		//从客户端传输给服务器数据的编码跟浏览器有关，浏览器打开页面的编码提交数据
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request.getContextPath());//工程路径
		System.out.println(request.getServletPath());//Servlet的请求路径
		System.out.println(request.getRequestURL());//请求url
		System.out.println(request.getRequestURI());//contextPath+servletPath
		
		
		System.out.println(request.getRemoteAddr());
		
		String name=request.getParameter("name");
		
		System.out.println(name);
		
		name=new String(name.getBytes("iso8859-1"),"utf-8");
		
		System.out.println(name);
		
		
		String password=request.getParameter("password");
		System.out.println(password);
		
		Map map=request.getParameterMap();
		System.out.println(map);
		
		Set<Map.Entry> entrySet=map.entrySet();
		
		for (Map.Entry entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(Arrays.toString((String[])entry.getValue()));
		}
		
		String[] names=request.getParameterValues("name");
		System.out.println(Arrays.toString(names));
		
		System.out.println(request.getParameter("textarea"));
		
		System.out.println(request.getParameter("radio"));
		
		System.out.println(request.getParameter("select"));
		
		String[] checkbox=request.getParameterValues("checkbox");
		System.out.println(Arrays.toString(checkbox));
		
	}
//	@Override
//	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("doGet...");
//	}
	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doPost...");
//	}
}
