package day01;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class Person implements Serializable {
	private Integer id;
	private String name;
	private Date birthday;
	private Boolean sex;
	private String[] hobbies;
	public Person() {
		super();
	}
	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getHob(){
		if(hobbies!=null){
			return StringUtils.join(hobbies,",");
		}
		return null;
	}
	public void setHob(String hob){
		if(hob!=null){
			hobbies=hob.split(",");
		}
	}
	
	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
}
