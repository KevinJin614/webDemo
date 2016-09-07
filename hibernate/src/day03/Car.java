package day03;

import java.io.Serializable;

public class Car implements Serializable {
	private Integer id;
	private String name;
	private Engine engine;
	public Car() {
		super();
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
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
