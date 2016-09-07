package dao;

import entity.User;

public interface UserDao extends GenericDao<User,Integer> {
	public User selectByUsername(String username);
	
	public User selectByUsernameAndPassword(String username,String password);
}
