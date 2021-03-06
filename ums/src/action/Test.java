package action;

import java.util.Scanner;

import entity.User;
import exception.DuplicateUsernameException;
import exception.ServiceException;
import exception.UserNotFoundException;
import factory.ObjectFactory;

import service.UserService;

public class Test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("用户注册");
//		System.out.println("用户名：");
//		String username=sc.nextLine();
//		System.out.println("密码：");
//		String password=sc.nextLine();
//		System.out.println("姓名：");
//		String name=sc.nextLine();
//		System.out.println("电话：");
//		String phone=sc.nextLine();
//		
		UserService userService=(UserService) ObjectFactory.getObject("userService");
		
		
		
//		User user=new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setName(name);
//		user.setPhone(phone);
//		
//		try {
//			userService.regist(user);
//			System.out.println("注册成功");
//		} catch (DuplicateUsernameException e) {
//			System.out.println(e.getMessage());
//		} catch (ServiceException e) {
//			System.out.println("系统忙，稍后再试！");
//		}
		
		
		
		System.out.println("用户登陆");
		System.out.println("用户名：");
		String username=sc.nextLine();
		System.out.println("密码：");
		String password =sc.nextLine();
		
		try {
			User user=userService.login(username, password);
			System.out.println(user.getUsername()+"登陆成功");
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ServiceException e) {
			System.out.println("系统忙，稍后再试！");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
