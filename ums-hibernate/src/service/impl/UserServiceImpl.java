package service.impl;

import java.util.Date;
import java.util.List;

import service.UserService;
import transaction.TransactionManager;
import util.MD5Util;
import dao.UserDao;
import entity.User;
import exception.DataAccessException;
import exception.DuplicateUsernameException;
import exception.UserNotFoundException;
import factory.ObjectFactory;

public class UserServiceImpl implements UserService {
	

	public void regist(User user) throws DuplicateUsernameException {
		UserDao userDao=(UserDao) ObjectFactory.getObject("userDao");
		
		//根据用户名查询用户
		User u=userDao.selectByUsername(user.getUsername());
		//如果找到记录，用户名已存在
		if(u!=null){
			//抛出DuplicateUsernameException
			throw new DuplicateUsernameException("用户名已存在");
		}
		
		//设置注册时间
		user.setRegistDate(new Date());
		
		//密码加密
		user.setPassword(MD5Util.md5(user.getPassword()));
		
		//保存数据
		userDao.insert(user);
		
		
	}

	public User login(String username, String password) throws UserNotFoundException {
		UserDao userDao=(UserDao) ObjectFactory.getObject("userDao");
		User user=userDao.selectByUsernameAndPassword(username, MD5Util.md5(password));
		if(user==null){
			throw new UserNotFoundException("用户名或密码错误");
		}
		return user;
	}

	public void modify(User user) {
		// TODO Auto-generated method stub
		
	}

}
