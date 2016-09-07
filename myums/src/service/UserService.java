package service;

import entity.User;
import exception.DuplicateUsernameException;

/**
 * 用户服务对象
 * @author 靳雅楠
 *
 */
public interface UserService {
	/**
	 * 用户注册
	 * @param user 封装了用户注册信息的用户对象
	 * @throws DuplicateUsernameException 重复的用户名异常，当用户注册的用户名在本系统已存在时，抛出此异常
	 * @throws ServiceException 服务失败异常，抛出此异常
	 */
	public void regist(User user) throws DuplicateUsernameException;
	
}
