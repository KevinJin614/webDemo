package day01;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.xml.sax.SAXException;

public class TestActionParser {
	public static void main(String[] args) {
		Digester digester = DigesterLoader
								.createDigester(TestActionParser.class
																.getClassLoader()
																.getResource("day01/rule1.xml"));
		ModuleConfig moduleConfig = new ModuleConfig();
		digester.push(moduleConfig);
		
		try {
			digester.parse(TestActionParser.class
										   .getClassLoader()
										   .getResourceAsStream("action.xml"));
			
			System.out.println(moduleConfig.findAction("/regist").getMethod());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
