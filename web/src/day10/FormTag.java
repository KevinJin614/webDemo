package day10;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FormTag extends SimpleTagSupport {
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();

		JspWriter out = pageContext.getOut();
		
		out.println("<form action='"+action+"' method='post'>");
		out.println("	用户名：<input type='text' name='username'/></br>");
		out.println("	密码：<input type='password' name='password'/></br>");
		out.println("	<input type='submit' value='登陆'/>");
		out.println("</form>");
		HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
		
		String message=(String) request.getAttribute("message");
		if(message!=null){
			out.println(message);
		}
		
		
		
	}

}
