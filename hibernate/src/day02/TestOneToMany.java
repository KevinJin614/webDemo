package day02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestOneToMany {
	public static void main(String[] args) {
//		Order order=new Order();
//		order.setOwner("bcd");
//		
//		Item item1=new Item();
//		item1.setProduct("aaa");
//		item1.setNum(2);
//		
////		Item item2=new Item();
////		item2.setProduct("bbb");
////		item2.setNum(2);
//		
//		Item item3=new Item();
//		item3.setProduct("ccc");
//		item3.setNum(5);
//		
//		item1.setOrder(order);
////		item2.setOrder(order);
//		item3.setOrder(order);
//		
//		order.addItem(item1);
////		order.addItem(item2);
//		order.addItem(item3);
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			
//			session.save(order);
//			session.save(item1);
////			session.save(item2);
//			session.save(item3);
			
			
//			Order order=(Order) session.get(Order.class, 1);
//			
//			
//			System.out.println(order.getId()+" "+order.getOwner());
//			
//			Set<Item> items=order.getItems();
//			for (Item item : items) {
//				System.out.println(item.getId()+" "+item.getProduct()+" "+item.getNum());
//			}
			
//			String hql=new StringBuffer()
////				.append("select distinct o ")
//				.append("from Order o ")
////				.append("join fetch o.items i ")
//				.toString();
//			
//			List<Order> orders=session.createQuery(hql)
//									  .list();
//			
//			System.out.println(orders);
			
//			Set set=new HashSet(orders);
//			
//			orders=new ArrayList(set);
//			System.out.println(orders);
			
//			for (Order order : orders) {
//				System.out.println(order.getId()+" "+order.getOwner());
//				Set<Item> items=order.getItems();
//				for (Item item : items) {
//					System.out.println(item.getId()+" "+item.getProduct()+" "+item.getNum());
//				}
//			}
			
//			for (Order order : orders) {
//				System.out.println(order.getId()+" "+order.getOwner()+" "+order.getCount());
//			}
			
			//找出买了aaa商品的所有订单
			String hql=new StringBuffer()
				.append("from Order o ")
				.append("join fetch o.items i ")
				.append("where i.product=:product ")//集合中每一个元素的属性
				.toString();
			
			List<Order> orders=session.createQuery(hql)
									  .setString("product", "aaa")
									  .list();
			
			System.out.println(orders);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		
		
		
		
		
		
	}
}
