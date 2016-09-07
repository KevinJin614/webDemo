package dao;

import entity.Manager;

public interface ManagerDao extends GenericDao<Manager, Integer> {
	public Manager selectByUsernameAndPassword(String username,String password);
}
