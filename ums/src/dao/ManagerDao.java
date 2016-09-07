package dao;

import entity.Manager;
import exception.DataAccessException;

/**
 * 管理员数据访问对象
 * @author 李恒
 *
 */
public interface ManagerDao {
	/**
	 * 根据用户名和密码查询一个管理员
	 * @param username 用户名
	 * @param password 密码
	 * @return 封装了管理员信息的管理员对象，如果不存在，返回null
	 * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
	 */
	public Manager selectByUsernameAndPassword(String username,String password);
}
