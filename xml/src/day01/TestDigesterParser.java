package day01;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.xml.sax.SAXException;

public class TestDigesterParser {
	public static void main(String[] args) {
		Digester digester=DigesterLoader.createDigester(TestDigesterParser.class
																		  .getClassLoader()
																		  .getResource("day01/rule.xml"));
		
		//准备一个空的班级对象
		ClassBean classBean=new ClassBean();
		//将这个班级对象给digester解析器，会将xml文件中的数据设置到这个对象上
		digester.push(classBean);
		
		
		//解析xml
		try {
			digester.parse(TestDigesterParser.class
											 .getClassLoader()
											 .getResourceAsStream("students.xml"));
			
			System.out.println(classBean.findStudent(2).getName());
			System.out.println(classBean.findStudent(2).getSex());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
