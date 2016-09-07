package day01;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class TestJdomParser {
	public static void main(String[] args) {
		SAXBuilder builder=new SAXBuilder();
		try {
			Document document=builder.build(TestJdomParser.class
														  .getClassLoader()
														  .getResourceAsStream("students.xml"));
			
			
			Element classElement=document.getRootElement();
			
			System.out.println(classElement.getAttributeValue("no"));
			
			List<Element> studentElements=classElement.getChildren("student");
			
			for (Element studentElement : studentElements) {
				System.out.println(studentElement.getAttributeValue("id"));
				System.out.println(studentElement.getAttributeValue("sex"));
				Element nameElement=studentElement.getChild("name");
				System.out.println(nameElement.getText());
				
				System.out.println(studentElement.getChildText("name"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
