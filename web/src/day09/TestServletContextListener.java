package day09;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		ServletContext application=event.getServletContext();
		System.out.println(application.getInitParameter("a"));
	}

}
