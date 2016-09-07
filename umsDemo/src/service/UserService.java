package service;

import entity.User;
import exception.DuplicateUsernameException;
import exception.UserNotFoundException;

public interface UserService {
	public void regist(User user) throws DuplicateUsernameException ;
	public User login(String username,String password) throws UserNotFoundException;
	public User modify(User user);
}
