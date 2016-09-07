package day01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		
		
//		String url="jdbc:oracle:thin:@10.0.5.98:1521:abc";
//		String driver="oracle.jdbc.driver.OracleDriver";
//		String username="scott";
//		String password="tiger";
//		
//		Class.forName(driver);
//		
//		Connection con=DriverManager.getConnection(url,username,password);
//		System.out.println(con);
//		con.close();
		
		
		
		
		
//		Configuration cfg=new Configuration();
//		cfg.configure();//类加载路径下hibernate.cfg.xml
////		cfg.configure("xxx/xxx.xml");
//		
//		
//		SessionFactory sf=cfg.buildSessionFactory();
		
//		Session session=sf.openSession();
		
		Session session=null;
		
		try {
			session=HibernateUtil.getSession();
			
			Person p=new Person();
			p.setName("bbb");
			p.setSex(false);
			p.setBirthday(java.sql.Date.valueOf("1999-12-15"));
			
//			session.beginTransaction();
			Transaction tran1=session.beginTransaction();
			Transaction tran2=session.getTransaction();
//			tran2.begin();
			Transaction tran3=session.getTransaction();
			session.save(p);
			
			Transaction tran4=session.getTransaction();
			
			System.out.println(tran1);
			System.out.println(tran2);
			System.out.println(tran3);
			System.out.println(tran4);
			
			session.getTransaction().commit();
//			tran1.commit();
			
			Transaction tran5=session.getTransaction();
			System.out.println(tran5);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtil.closeSession(session);
		}
		
//		session.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
