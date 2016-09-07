package day08;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Order implements Serializable {
	private Integer id;
	private User user;
	private String no;
	private Double price;
	private Set<Item> items=new HashSet<Item>();
	private Integer count;
	public Order() {
		super();
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void addItem(Item item){
		items.add(item);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
