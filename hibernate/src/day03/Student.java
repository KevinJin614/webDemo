package day03;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {
	private Integer id;
	private String name;
	private Set<Course> courses=new HashSet<Course>();
	public Student() {
		super();
	}
	public void addCourse(Course course){
		courses.add(course);
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
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
