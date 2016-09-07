package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

public class CheckLoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		User user = (User) request.getSession().getAttribute("user");
		if(user != null){
			chain.doFilter(request, response);
			return;
		}
		response.sendRedirect(request.getContextPath()+"show/shop/login");
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
