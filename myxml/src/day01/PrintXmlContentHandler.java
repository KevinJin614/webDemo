package day01;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class PrintXmlContentHandler implements ContentHandler {

	//读到文本内容时调用
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch,start,length));
	}

	//文档读取结束前调用
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	//读到尾标签时调用
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</"+qName+">");
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

	//读到文档开头调用
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	//读到标签开始调用
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.print("<"+qName+" ");
		for (int i = 0; i < atts.getLength(); i++) {
			System.out.print(atts.getQName(i)+"=\""+atts.getValue(i)+"\" ");
		}
		System.out.print(">");
	}

	public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
