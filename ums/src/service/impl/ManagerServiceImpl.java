package service.impl;

import java.util.List;

import dao.ManagerDao;
import dao.UserDao;

import entity.Manager;
import entity.User;
import exception.UserNotFoundException;
import factory.ObjectFactory;
import service.ManagerService;
import util.MD5Util;

public class ManagerServiceImpl implements ManagerService{
	private ManagerDao managerDao;
	private UserDao userDao;
	public ManagerServiceImpl(){
		userDao = (UserDao) ObjectFactory.getObject("userDao");
		managerDao = (ManagerDao) ObjectFactory.getObject("managerDao");
	}
	public List<User> findAll() {
		return userDao.selectAll();
	}

	public User findById(Integer id) {
		User user = userDao.selectById(id);
		return user;
	}

	public Manager login(String username, String password)
			throws UserNotFoundException {
		Manager manager = managerDao.selectByUsernameAndPassword(username, MD5Util.md5(password));
		if(manager == null){
			throw new UserNotFoundException("用户名或密码错误");
		}
		return manager;
	}

	public void removeById(Integer id) {
		userDao.deleteById(id);
	}
	
}
