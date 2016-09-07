package day03.pm;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestExtends {
	public static void main(String[] args) {
//		Manager manager=new Manager();
//		manager.setUsername("admin");
//		manager.setPassword("admin");
//		manager.setEmail("a@a.com");
//		
//		Member member=new Member();
//		member.setUsername("abc");
//		member.setPassword("123");
//		member.setPhone("12345678");
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
//			session.save(manager);
//			session.save(member);
			
////			Manager manager=(Manager) session.get(Manager.class, 1);
//			
//			Manager manager=(Manager) session.get(User.class, 1);
////			
//			System.out.println(manager.getId()+" "+manager.getUsername()+" "+manager.getPassword()+" "+manager.getEmail());
			
			String hql=new StringBuffer()
//				.append("from Manager ")
				.append("from User ")
				.toString();
			
			List list=session.createQuery(hql)
							 .list();
			
			System.out.println(list);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		
	}
}
