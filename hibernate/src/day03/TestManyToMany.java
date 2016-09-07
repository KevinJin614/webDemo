package day03;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestManyToMany {
	public static void main(String[] args) {
		Course c1=new Course();
		c1.setName("java");
		
		Course c2=new Course();
		c2.setName("oracle");
		
		Student s1=new Student();
		s1.setName("aaa");
		
		Student s2=new Student();
		s2.setName("bbb");
		
		c1.addStudent(s1);
		c1.addStudent(s2);
		c2.addStudent(s2);
		
		s1.addCourse(c1);
		s2.addCourse(c1);
		s2.addCourse(c2);
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
			session.save(c1);
			session.save(c2);
			
			session.save(s1);
			session.save(s2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
