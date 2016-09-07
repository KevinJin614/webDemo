package service.proxy;

import entity.User;
import exception.DataAccessException;
import exception.DuplicateUsernameException;
import exception.ServiceException;
import exception.UserNotFoundException;
import factory.ObjectFactory;
import service.UserService;
import transaction.TransactionManager;

public class UserServiceProxy implements UserService {

	private UserService userService;
	
	public UserServiceProxy() {
		userService=(UserService) ObjectFactory.getObject("userServiceTarget");
	}
	
	public void regist(User user) throws DuplicateUsernameException {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			userService.regist(user);
			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
			tran.rollback();
			throw new ServiceException(e);
		} catch (DuplicateUsernameException e) {
			tran.rollback();
			throw e;
		}
	}

	public User login(String username, String password) throws UserNotFoundException {
		User user=null;
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			user=userService.login(username, password);
			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
			tran.rollback();
			throw new ServiceException(e);
		} catch (UserNotFoundException e) {
			tran.rollback();
			throw e;
		}
		return user;
	}

	public void modify(User user) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			tran.beginTransaction();
			userService.modify(user);
			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
			tran.rollback();
			throw new ServiceException(e);
		} 
		
	}

	public User checkName(String username) throws UserNotFoundException {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		User user = null;
		try {
			tran.beginTransaction();
			user = userService.checkName(username);
			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
			tran.rollback();
			throw new ServiceException(e);
		} 
		return user;
	}

}
