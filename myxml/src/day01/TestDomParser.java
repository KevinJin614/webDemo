package day01;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestDomParser {
	public static void main(String[] args) {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser=factory.newDocumentBuilder();
			
			//将xml解析完成，文件已经读取完毕，在内存中已经存在一个树形结构
			Document document=parser.parse(TestDomParser.class
														.getClassLoader()
														.getResourceAsStream("students.xml"));
			
			//跟标签
			Element root=document.getDocumentElement();
			
			print(root);
			
			
			
			
			
			
			
			
			
			
			
//			System.out.println(root);
			
//			String no=root.getAttribute("no");
//			System.out.println(no);
//			
//			System.out.println(root.getTagName());
//			
//			NodeList nodeList=root.getChildNodes();
//			
//			System.out.println(nodeList.getLength());
//			
//			for (int i = 0; i < nodeList.getLength(); i++) {
////				System.out.println("----------");
////				System.out.println(nodeList.item(i));
////				System.out.println("----------");
//				Node node=nodeList.item(i);
//				
//				short nodeType=node.getNodeType();
//				
////				System.out.println(nodeType);
//				if(nodeType==Node.TEXT_NODE){
//					System.out.println(node.getNodeValue());
//				}
//				if(nodeType==Node.ELEMENT_NODE){
//					Element childElement=(Element)node;
//					System.out.println(childElement.getTagName());
//				}
//				
//				
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void print(Element root){
		System.out.print("<"+root.getTagName()+" ");
		NamedNodeMap map=root.getAttributes();
		if(map!=null){
		
			for (int i = 0; i < map.getLength(); i++) {
				Attr attr=(Attr) map.item(i);//Node   Attr
				System.out.print(attr.getName()+"=\""+attr.getValue()+"\" ");
			}
		}
		System.out.print(">");
		
		NodeList nodeList=root.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node=nodeList.item(i);
			short nodeType=node.getNodeType();
			if(nodeType==Node.TEXT_NODE){
				System.out.print(node.getNodeValue());
			}
			if(nodeType==Node.ELEMENT_NODE){
				Element element=(Element) node;
				print(element);
			}
		}
		
		System.out.print("</"+root.getTagName()+">");
	}
	
	
	
	
	
	
	
	
}
