package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Manager;
import entity.User;
import exception.ServiceException;
import exception.UserNotFoundException;
import factory.ObjectFactory;
import service.proxy.ManagerServiceProxy;

public class ManagerAction extends BaseAction{
	private String username;
	private String password;
	private String id;
	private String message;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	private ManagerServiceProxy managerService;
	public ManagerAction(){
		managerService = (ManagerServiceProxy) ObjectFactory.getObject("managerService");
	}
	public String login() throws Exception{
		Manager manager = null;
		try {
			manager = managerService.login(username, password);
		} catch (ServiceException e){
			message = "系统忙，请稍后再试！";
			e.printStackTrace();
			return "busy";
		} catch (UserNotFoundException e){
			message = "用户名或密码错误";
			e.printStackTrace();
			return "fail";
		}
		session.put("manager", manager);
		return SUCCESS;
	}
	
	public String findAll() throws Exception{
		List<User> users = null;
		try {
			users = managerService.findAll();
		} catch (ServiceException e){
			message = "系统忙，请稍后再试！";
			e.printStackTrace();
			return "busy";
		}
		request.setAttribute("users", users);
		return SUCCESS;
	}
	
	public String findById() throws Exception{
		User user = null;
		try {
			user = managerService.findById(Integer.parseInt(id));
		} catch (ServiceException e){
			message = "系统忙，请稍后再试！";
			e.printStackTrace();
			return "busy";
		}
		request.setAttribute("user", user);
		return SUCCESS;
	}
	
	public String removeById() throws Exception{
		try {
			managerService.removeById(Integer.parseInt(id));
		} catch (ServiceException e){
			message = "系统忙，请稍后再试！";
			e.printStackTrace();
			return "busy";
		}
		return SUCCESS;
	}
	
	public String logout() throws Exception{
		session.remove("manager");
		return SUCCESS;
	}
	
	
}
