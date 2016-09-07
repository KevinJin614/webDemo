package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class LoginAction extends BaseAction {
	
	private String username;
	private String password;
	
	private String message;
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String login()throws Exception {
//		Map<String,Object> session=ActionContext.getContext().getSession();
//		Map<String,Object> application=ActionContext.getContext().getApplication();
//		Map<String,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		
//		HttpServletRequest request=ServletActionContext.getRequest();
//		HttpServletResponse response=ServletActionContext.getResponse();
//		ServletContext application=ServletActionContext.getServletContext();
//		HttpSession session=request.getSession();
		
		System.out.println(request.getRemoteAddr());
		if("abc".equals(username)&&"123".equals(password)){
			session.put("username", username);
//			session.setAttribute("username", username);
//			return "success";
			return SUCCESS;
		}
		message="用户名或密码错误";
		return "fail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
