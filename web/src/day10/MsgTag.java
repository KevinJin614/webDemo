package day10;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MsgTag extends SimpleTagSupport{
	private String info;
	private int num;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext=(PageContext) getJspContext();
		
		
		JspWriter out=pageContext.getOut();
		
		for (int i = 0; i < num; i++) {
			out.println(info+"<br/>");
		}
		
	}
}
