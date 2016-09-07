package transaction.impl;

import java.sql.Connection;

import transaction.TransactionManager;
import util.JDBCUtil;
import exception.DataAccessException;

public class TransactionManagerImpl implements TransactionManager {

	public void beginTransaction() {
		Connection con=null;
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
	}

	public void commit() {
		Connection con=null;
		try {
			con=JDBCUtil.getConnection();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		} finally {
			JDBCUtil.close();
		}
	}

	public void rollback() {
		Connection con=null;
		try {
			con=JDBCUtil.getConnection();
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			//通知管理员的代码
		} finally {
			JDBCUtil.close();
		}
	}

}
