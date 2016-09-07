package day02;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestManyToOne {
	public static void main(String[] args) {
//		Dept dept=new Dept();
////		dept.setName("d3");
//		dept.setId(2);
//		
//		Emp emp=new Emp();
//		emp.setName("eee");
//		
//		emp.setDept(dept);
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
//			session.save(dept);
//			session.save(emp);
			
//			session.save(emp);
//			session.save(dept);
			
//			session.save(emp);
			
//			Emp emp=(Emp) session.get(Emp.class, 4);
//			
//			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getDept().getId());
//			System.out.println(emp.getDept().getClass());
//			System.out.println(emp.getDept().getName());
			
//			String hql=new StringBuffer()
////				.append("select e ")
//				.append("from Emp e ")
////				.append("left join e.dept d ")
//				.append("left join fetch e.dept d ")
//				.toString();
//			
//			List<Emp> emps=session.createQuery(hql)
//								  .list();
////			List<Object[]> emps=session.createQuery(hql)
////									   .list();
//			
//			System.out.println(emps);
//			
//			for (Emp emp : emps) {
//				System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getDept().getId());
//				System.out.println(emp.getDept().getName());
//			}
//			
////			for (Object[] emp : emps) {
////				System.out.println("----------------------------------------");
////				System.out.println(Arrays.toString(emp));
////				Emp e=(Emp) emp[0];
////				Dept d=(Dept) emp[1];
////				System.out.println(e.getId()+" "+e.getName()+" "+e.getDept());
////				System.out.println(d.getId()+" "+d.getName());
////				System.out.println("----------------------------------------");
////			}
			
			
			//找出d2（部门名称）部门的所有员工
			String hql=new StringBuffer()
				.append("from Emp e ")
//				.append("join fetch e.dept d ")
//				.append("where d.name=:name ")
				.append("where e.dept.name=:name ")
				.toString();
			
			List<Emp> emps=session.createQuery(hql)
							      .setString("name", "d2")
							      .list();
			System.out.println(emps);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		
	}
}
