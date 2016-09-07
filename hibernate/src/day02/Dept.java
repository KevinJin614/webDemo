package day02;

import java.io.Serializable;

public class Dept implements Serializable {
	private Integer id;
	private String name;
	public Dept() {
		super();
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
