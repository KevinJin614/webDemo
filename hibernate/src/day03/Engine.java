package day03;

import java.io.Serializable;

public class Engine implements Serializable {
	private Integer id;
	private String name;
	private Car car;
	public Engine() {
		super();
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
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
