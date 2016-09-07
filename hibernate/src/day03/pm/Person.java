package day03.pm;

import java.io.Serializable;

public class Person implements Serializable {
	private Integer id;
	private Name name;
	public Person() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
}
