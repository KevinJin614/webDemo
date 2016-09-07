package day01;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class XMLContentHandler implements ContentHandler{

	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void endDocument() throws SAXException {
		System.out.println("xml文件解析结束");
	}

	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		System.out.println("标签结尾");
	}

	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void processingInstruction(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub
		
	}

	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void startDocument() throws SAXException {
		System.out.println("开始解析xml文件");
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("-----------------------------------");
		System.out.println("uri="+uri);
		System.out.println("localName="+localName);
		System.out.println("qName="+qName);
		System.out.println("id="+atts.getValue("id"));
		System.out.println("-----------------------------------");
	}

	public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
