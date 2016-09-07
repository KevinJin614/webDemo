package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.proxy.UserServiceProxy;
import entity.User;
import exception.DuplicateUsernameException;
import exception.ServiceException;
import exception.UserNotFoundException;
import factory.ObjectFactory;

public class UserAction extends BaseAction{
	private String username;
	private String password;
	private String name;
	private String phone;
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	private UserServiceProxy userService;
	public UserAction(){
		userService =  (UserServiceProxy) ObjectFactory.getObject("userService");
	}
	public String login() throws Exception{
		User user = null;
		try {
			user = userService.login(username, password);
		} catch (UserNotFoundException e) {
			message = "用户名或密码错误";
			e.printStackTrace();
			return "fail";
		} catch (ServiceException e){
			message = "系统忙，请稍后再试！";
			e.printStackTrace();
			return "busy";
		}
		session.put("user", user);
		return SUCCESS;
	}
	
	public String regist() throws Exception{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setPhone(phone);
		try {
			userService.regist(user);
		} catch (ServiceException e) {
			message = "系统忙，请稍后再试！";
			e.printStackTrace();
			return "busy";	
		} catch (DuplicateUsernameException e){
			message = e.getMessage();
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
		
	}
	
	public String modify() throws Exception{
		User u1 = (User) request.getSession().getAttribute("user");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setPhone(phone);
		user.setRegistDate(u1.getRegistDate());
		try {
			userService.modify(user);
		} catch (ServiceException e) {
			message = "系统忙，请稍后再试！";
			e.printStackTrace();
			return "busy";	
		} 
		session.put("user", user);
		return SUCCESS;
	}
	
	public String logout() throws Exception{
		session.remove("user");
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
}
