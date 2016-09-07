package day03.pm;

import java.io.Serializable;

public class Member extends User implements Serializable {
	private String phone;

	public Member() {
		super();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
