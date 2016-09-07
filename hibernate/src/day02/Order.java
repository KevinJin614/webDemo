package day02;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Order implements Serializable {
	private Integer id;
	private String owner;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
