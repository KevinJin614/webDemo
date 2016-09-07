package day03;

import java.util.Set;

import org.hibernate.Session;

import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Order order=selectByNo("O01");
		System.out.println(order.getUser().getUsername()+"用户"+order.getNo()+"订单");
		System.out.println("-------------------------------------");
		System.out.println("序号\t商品\t数量\t价格");
		Set<Item> items=order.getItems();
		int i=1;
		for (Item item : items) {
			System.out.println(i+++"\t"+item.getProduct().getName()+"\t"+item.getNum()+"\t"+item.getPrice());
		}
		System.out.println("-------------------------------------");
		System.out.println("共"+order.getCount()+"条\t\t总计："+order.getPrice()+"元");
	}
	
	public static Order selectById(Integer id){
		Session session=null;
		Order order=null;
		try {
			session=HibernateUtil.getSession();
			
			order=(Order) session.get(Order.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return order;
	}
	
	public static Order selectByNo(String no){
		Session session=null;
		Order order=null;
		try {
			session=HibernateUtil.getSession();
			
			String hql=new StringBuffer()
				.append("select distinct o ")
				.append("from Order o ")
				.append("left join fetch o.user u ")
				.append("left join fetch o.items i ")
				.append("left join fetch i.product p ")
				.append("where o.no=:no ")
				.toString();
			
			order=(Order) session.createQuery(hql)
								 .setString("no", no)
								 .uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return order;
	}
}
