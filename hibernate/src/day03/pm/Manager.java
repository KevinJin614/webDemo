package day03.pm;

import java.io.Serializable;

public class Manager extends User implements Serializable {
	private String email;

	public Manager() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
