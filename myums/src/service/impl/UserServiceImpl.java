package service.impl;

import java.util.Date;

import dao.UserDao;
import entity.User;
import exception.DuplicateUsernameException;
import service.UserService;
import util.MD5Util;

public class UserServiceImpl implements UserService{

	public void regist(User user) throws DuplicateUsernameException {
		//获得UserDao对象
		UserDao userDao = null; 
		//根据username查询数据库
		User u = userDao.selectByUsername(user.getName());
		if(u != null){
			//如果存在，抛DuplicateUsernameException
			throw new DuplicateUsernameException("用户名已注册");
		}
		//增加注册时间
		user.setRegistDate(new Date());
		
		
		//密码加密
		user.setPassword(MD5Util.md5(user.getPassword()));
		
		//插入数据库
		userDao.insert(user);
	}
	
}
