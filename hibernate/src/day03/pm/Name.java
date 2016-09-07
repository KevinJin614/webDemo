package day03.pm;

import java.io.Serializable;

public class Name implements Serializable {
	private String firstName;
	private String lastName;
	public Name() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
