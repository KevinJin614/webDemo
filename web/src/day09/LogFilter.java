package day09;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
		//日志
		System.out.println(req.getRemoteAddr()+"在"+new Date()+"发送了"+req.getRequestURI()+"请求");
		
		//调用下一个组件
		chain.doFilter(req, res);
		
		//日志
		System.out.println(new Date()+"执行完了"+req.getRequestURI()+"操作"+res.getContentType());
		
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
