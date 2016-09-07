package day03.pm;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestComponent {
	public static void main(String[] args) {
//		Person p=new Person();
//		Name name=new Name();
//		name.setFirstName("aaa");
//		name.setLastName("bbb");
//		p.setName(name);
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
//			session.save(p);
			
			//找出firstName为aaa的人
			String hql=new StringBuffer()
				.append("from Person p ")
				.append("where p.name.firstName=:firstName ")
				.toString();
			
			List<Person> persons=session.createQuery(hql)
										.setString("firstName", "aaa")
										.list();
			
			System.out.println(persons);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}
