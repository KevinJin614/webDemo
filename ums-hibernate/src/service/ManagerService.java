package service;

import java.util.List;

import entity.Manager;
import entity.User;
import exception.ServiceException;
import exception.UserNotFoundException;

/**
 * 管理员服务对象
 * @author 李恒
 *
 */
public interface ManagerService {
	/**
	 * 管理员登陆
	 * @param username 用户名
	 * @param password 密码
	 * @return 封装了登陆管理员信息的管理员对象
	 * @throws UserNotFoundException 用户不存在异常，当输入的用户名或密码错误时，抛出此异常
	 * @throws ServiceException 服务失败异常，当此业务操作未成功时，抛出此异常
	 */
	public Manager login(String username,String password)throws UserNotFoundException;
	
	/**
	 * 查询所有用户
	 * @return 封装了所有用户信息的集合
	 * @throws ServiceException 服务失败异常，当此业务操作未成功时，抛出此异常
	 */
	public List<User> findAll();
	
	/**
	 * 根据用户主键删除一个用户
	 * @param id 用户主键
	 * @throws ServiceException 服务失败异常，当此业务操作未成功时，抛出此异常
	 */
	public void removeById(Integer id);
	
	/**
	 * 根据用户主键查询一个用户
	 * @param id 用户主键
	 * @return 封装了用户信息的用户对象
	 * @throws ServiceException 服务失败异常，当此业务操作未成功时，抛出此异常
	 */
	public User findById(Integer id);
	
	
	
	
	
	
	
}
