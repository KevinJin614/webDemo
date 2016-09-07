package action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware,SessionAware {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;
	protected Map<String, Object> session;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	public void setServletContext(ServletContext application) {
		this.application=application;
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
