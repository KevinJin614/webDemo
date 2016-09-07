
package day01;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class TestSAXParser {
	
	
	public static void main(String[] args) throws IOException {
		try {
			XMLReader parser=XMLReaderFactory.createXMLReader();
			//解析xml文件时，做事件注册
			parser.setContentHandler(new PrintXmlContentHandler());
			
			parser.parse(new InputSource(TestSAXParser.class
													  .getClassLoader()
													  .getResourceAsStream("students.xml")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		File file=new File("../students.xml");
//		
//		System.out.println(file.getPath());
//		
//		System.out.println(file.getAbsolutePath());
//		
//		System.out.println(file.getCanonicalPath());
		
//		URL url=TestSAXParser.class
//							 .getClassLoader()
//							 .getResource("students.xml");
//		System.out.println(url);
//		
//		InputStream in=TestSAXParser.class
//									.getClassLoader()
//									.getResourceAsStream("students.xml");
//		
//		System.out.println(in.available());
		
		
		
		
		
		
		
		
		
		
	}
}
