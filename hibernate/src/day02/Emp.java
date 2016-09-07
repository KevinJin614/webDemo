package day02;

import java.io.Serializable;

public class Emp implements Serializable {
	private Integer id;
	private String name;
	private Dept dept;
	public Emp() {
		super();
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
