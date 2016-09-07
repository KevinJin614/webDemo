package entity;

import java.io.Serializable;

/**
 * 管理员实体
 * @author 李恒
 *
 */
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	public Manager() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
