package day03;


import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestService implements Servlet {
	private ServletConfig config;
	//初始化方法 自动执行
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		System.out.println("init...");
		init();
	}
	//业务方法 发送请求时执行
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service...");
		service((HttpServletRequest)request, (HttpServletResponse)response);
	}
	//销毁方法 自动执行
	public void destroy() {
		System.out.println("destory...");
	}

	public void init(){
		
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	
	public ServletConfig getServletConfig() {
		return config;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}





}
