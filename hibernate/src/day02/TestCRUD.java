package day02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import util.HibernateUtil;
import day01.Person;

public class TestCRUD {
	public static void main(String[] args) {
//		Person p=new Person();
//		p.setId(2);
//		p.setName("jjj");
//		p.setBirthday(new Date());
//		p.setSex(true);
//		p.setHobbies(new String[]{"吃","玩","睡 "});
//		
//		insert(p);
//		update(p);
//		
//		System.out.println(p.getId());
//		deleteById(1);
		
//		Person p=selectById(5123412);
//		System.out.println(p.getId());
//		System.out.println(p.getName());
//		System.out.println(p.getSex());
//		System.out.println(p.getHob());
//		System.out.println(p.getBirthday());
		
		
//		List<Person> persons=selectByHobby("玩");
//		
//		for (Person person : persons) {
//			System.out.println(person.getId()+" "+person.getName()+" "+person.getSex());
//		}
		
//		updateNameById(6, "bbb");
		
		
//		updateBirthdayById(6, java.sql.Date.valueOf("1988-07-09"));
		
		
		select();
		
		
		
		
	}
	
	public static void insert(Person p){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
//			session.save(p);
//			
//			p.setName("aaa");
			
//			session.update(p);
			
			session.saveOrUpdate(p);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	public static void deleteById(Integer id){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
			Person p=new Person();
			p.setId(id);
			session.delete(p);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	public static void update(Person p){
//		Session session=null;
//		try {
//			session=HibernateUtil.getSession();
//			session.beginTransaction();
//			
//			session.update(p);
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		} finally {
//			HibernateUtil.closeSession(session);
//		}
		
		insert(p);
	}
	
	public static Person selectById(Integer id){
		Session session=null;
		Person p=null;
		try {
			session=HibernateUtil.getSession();
			
			System.out.println("1111111111111111111111111111");
//			p=(Person) session.get(Person.class,id);
			
			p=(Person) session.load(Person.class, id);
			
			System.out.println("22222222222222222222222222222");
			System.out.println(p.getClass());
			System.out.println(p.getName());
			
			System.out.println("333333333333333333333333333333");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return p;
	}
	
	public static List<Person> selectAll(){
		Session session=null;
		List<Person> persons=new ArrayList<Person>();
		try {
			session=HibernateUtil.getSession();
			
			String hql=new StringBuffer()
				.append("from Person")
				.toString();
				
//			Query query=session.createQuery(hql);
//			
//			persons=query.list();
			
			persons=session.createQuery(hql)
						   .setFirstResult(2)
						   .setMaxResults(3)
						   .list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return persons;
	}
	
	public static List<Person> selectAll(int pageNo,int maxSize){
		Session session=null;
		List<Person> persons=new ArrayList<Person>();
		try {
			session=HibernateUtil.getSession();
			
			String hql=new StringBuffer()
				.append("from Person")
				.toString();
				
//			Query query=session.createQuery(hql);
//			
//			persons=query.list();
			
			persons=session.createQuery(hql)
						   .setFirstResult((pageNo-1)*maxSize)
						   .setMaxResults(maxSize)
						   .list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return persons;
	}
	
	public static List<Person> selectByName(String name){
		Session session=null;
		List<Person> persons=new ArrayList<Person>();
		try {
			session=HibernateUtil.getSession();
			
			String hql=new StringBuffer()
				.append("from Person p ")
//				.append("where p.name=? ")
				.append("where p.name=:name ")
				.toString();
			persons=session.createQuery(hql)
//						   .setString(0, name)
						   .setString("name", name)
//						   .setFirstResult(0)
//						   .setMaxResults(2)
						   .list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return persons;
	}
	
	//根据兴趣爱好查询，如找出所有爱好玩的人
	public static List<Person> selectByHobby(String hobby){
		Session session=null;
		List<Person> persons=new ArrayList<Person>();
		try {
			session=HibernateUtil.getSession();
			
			String hql=new StringBuffer()
				.append("from Person p ")
				.append("where p.hob like :hobby ")
				.toString();
			
			persons=session.createQuery(hql)
						   .setString("hobby", "%"+hobby+"%")
						   .list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return persons;
	}
	
	public static void updateNameById(Integer id,String name){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
//			Person p=new Person();
//			p.setId(id);
//			p.setName(name);
//			session.update(p);
			
			Person p=(Person) session.get(Person.class, id);
			
			p.setName(name);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	public static void updateBirthdayById(Integer id,Date birthday){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
//			Person p=(Person) session.get(Person.class, id);
//			p.setBirthday(birthday);
//			
//			session.update(p);
			
			String hql=new StringBuffer()
				.append("update Person p ")
				.append("set p.birthday=:birthday ")
				.append("where id=:id ")
				.toString();
			
			session.createQuery(hql)
				   .setDate("birthday", birthday)
				   .setInteger("id", id)
				   .executeUpdate();
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	
	
	public static void select(){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
			String hql=new StringBuffer()
//				.append("select p ")
//				.append("select p.id,p.name ")
//				.append("select new Person(p.id,p.name) ")
//				.append("select new Map(p.id,p.name) ")
				.append("select new Map(p.id as id,p.name as name) ")
				.append("from Person p ")
				.toString();
			
//			List<Object[]> persons=session.createQuery(hql)
//										  .list();
//			List<Person> persons=session.createQuery(hql)
//										.list();
			List<Map> persons=session.createQuery(hql)
									 .list();
			
			
			System.out.println(persons);
			
//			for (Object[] person : persons) {
//				System.out.println(Arrays.toString(person));
//			}
//			for (Person person : persons) {
//				System.out.println(person.getId()+" "+person.getName()+" "+person.getSex());
//			}
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
