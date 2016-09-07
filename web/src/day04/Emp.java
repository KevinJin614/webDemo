package day04;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

public class Emp implements Serializable {
	private Integer id;
	private String name;
	private Double salary;
	private String sex;
	private String edu;
	private String[] hobbies;
	public Emp() {
		super();
	}
	public void setHob(String hob){
		if(hob!=null){
			hobbies=hob.split(",");
		}
	}
	public String getHob(){
		if(hobbies!=null){
			return StringUtils.join(hobbies,",");
		}
		return null;
	}
	
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((edu == null) ? 0 : edu.hashCode());
		result = PRIME * result + Arrays.hashCode(hobbies);
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		result = PRIME * result + ((salary == null) ? 0 : salary.hashCode());
		result = PRIME * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Emp other = (Emp) obj;
		if (edu == null) {
			if (other.edu != null)
				return false;
		} else if (!edu.equals(other.edu))
			return false;
		if (!Arrays.equals(hobbies, other.hobbies))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
