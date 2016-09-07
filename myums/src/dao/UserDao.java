package dao;

import entity.User;
import exception.DataAccessException;

/**
 * 用户数据访问对象
 * @author 靳雅楠
 *
 */
public interface UserDao {
	/**
	 * 根据用户名查询一个用户
	 * @param username 用户名
	 * @return 封装了用户信息的用户对象，如果不存在返回null
	 * @throws DataAccessException 数据访问异常，当此持久化操作为成功时，抛出此异常
	 */
	public User selectByUsername(String username);
	/**
	 * 保存一个用户
	 * @param user 封装了用户信息的用户对象
	 * @throws DataAccessException 数据访问异常，当此持久化操作为成功时，抛出此异常
	 */
	public void insert(User user);
}
