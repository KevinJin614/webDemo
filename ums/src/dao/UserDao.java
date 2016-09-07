package dao;

import java.util.List;

import entity.User;
import exception.DataAccessException;

/**
 * 用户数据访问对象
 * @author 李恒
 *
 */
public interface UserDao {
	/**
	 * 根据用户名查询一个用户
	 * @param username 用户名
	 * @return 封装了用户信息的用户对象，如果不存在，返回null
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public User selectByUsername(String username);
	
	/**
	 * 保存一个用户
	 * @param user 封装了用户信息的用户对象 
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public void insert(User user);
	
	/**
	 * 根据用户名和密码查询一个用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 封装了用户信息的用户对象，如果不存在，返回null
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public User selectByUsernameAndPassword(String username,String password);

	/**
	 * 修改一个用户信息，只允许修改用户名和电话
	 * @param user 封装了用户信息的用户对象
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public void update(User user);
	
	/**
	 * 查询所有用户
	 * @return 封装了所有用户信息的集合
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public List<User> selectAll();
	
	/**
	 * 根据主键删除一个用户
	 * @param id 用户主键
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public void deleteById(Integer id);
	
	/**
	 * 根据主键查询一个用户
	 * @param id 用户主键
	 * @return 封装了用户信息的用户对象
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public User selectById(Integer id);
	
	
	
}
