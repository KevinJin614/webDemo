package day09;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{
	private Integer count=0;
	public void sessionCreated(HttpSessionEvent event) {
		ServletContext application=event.getSession().getServletContext();
		synchronized (this) {
			application.setAttribute("count", ++count);
		}		
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		ServletContext application=event.getSession().getServletContext();
		synchronized (this) {
			application.setAttribute("count", --count);
		}	
	}
	
	
	
	
	
	
	
	

}
