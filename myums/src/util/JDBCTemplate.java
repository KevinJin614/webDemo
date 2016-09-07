package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Date;

import exception.DataAccessException;

public abstract class JDBCTemplate<T> {
	
	public void update(String sql,Object...params){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				setParm(i+1,params[i],ps);
			}
			ps.executeUpdate();
		} catch (Exception e) {
		} finally {
			JDBCUtil.close(null, ps, null);
		}
		
	}

	private void setParm(int index, Object param, PreparedStatement ps) throws Exception {
		if(param == null){
			ps.setNull(index, Types.VARCHAR);
			return;
		}
		if(param instanceof String){
			ps.setString(index, (String)param);
		}else if(param instanceof Date){
			ps.setDate(index, new java.sql.Date(((Date)param).getTime()));
		}else{
			ps.setObject(index, param);
		}
	}

	public T query(String sql,Object...params){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				setParm(i+1, params[i], ps);
			}
			rs = ps.executeQuery();
			return getT(rs);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("JDBCTemplate初始化错误"+e.getMessage());
		} finally {
			JDBCUtil.close(null, ps, rs);
		}
		
	}

	public abstract T getT(ResultSet rs) throws Exception ;
}
