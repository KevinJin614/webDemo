package service.proxy;

import java.util.List;

import entity.Manager;
import entity.User;
import exception.DataAccessException;
import exception.DuplicateUsernameException;
import exception.ServiceException;
import exception.UserNotFoundException;
import factory.ObjectFactory;
import service.ManagerService;
import transaction.TransactionManager;

public class ManagerServiceProxy implements ManagerService {
	
	private ManagerService managerService;
	public ManagerServiceProxy(){
		managerService = (ManagerService) ObjectFactory.getObject("managerServiceTarget");
	}
	public List<User> findAll() {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		List<User> users = null;
		try {
			tran.beginTransaction();
			users = managerService.findAll();
			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
			tran.rollback();
			throw new ServiceException(e);
		} 
		return users;
	}

	public User findById(Integer id) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		User user = null;
		try {
			tran.beginTransaction();
			user = managerService.findById(id);
			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
			tran.rollback();
			throw new ServiceException(e);
		} 
		return user;
	}

	public Manager login(String username, String password) throws UserNotFoundException {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		Manager manager = null;
		try {
			tran.beginTransaction();
			manager = managerService.login(username, password);
			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
			tran.rollback();
			throw new ServiceException(e);
		} catch (UserNotFoundException e){
			e.printStackTrace();
			throw e;
		}
		return manager;
	}

	public void removeById(Integer id) {
		TransactionManager tran=(TransactionManager) ObjectFactory.getObject("transaction");
		
		try {
			tran.beginTransaction();
			managerService.removeById(id);
			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
			tran.rollback();
			throw new ServiceException(e);
		} 
		
	}

}
