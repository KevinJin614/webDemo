package day01;

import java.util.HashMap;
import java.util.Map;

public class ClassBean {
	private Map<Integer,StudentBean> students=new HashMap<Integer, StudentBean>();

	public void addStudent(StudentBean student){
		students.put(student.getId(), student);
	}
	
	public StudentBean findStudent(Integer id){
		return students.get(id);
	}
	
	
	public Map<Integer, StudentBean> getStudents() {
		return students;
	}

	public void setStudents(Map<Integer, StudentBean> students) {
		this.students = students;
	}
	
	
}
