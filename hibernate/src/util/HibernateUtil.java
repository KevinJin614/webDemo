package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	
	static{
		try {
			sf=new Configuration()
				.configure()
				.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("HibernateUtil初始化错误"+e);
		}
	}

	public static Session getSession(){
		return sf.openSession();
	}
	
	public static void closeSession(Session session){
		if(session!=null){
			session.close();
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
