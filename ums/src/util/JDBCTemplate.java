package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.DataAccessException;


public class JDBCTemplate {
	public void update(String sql,Object... params){
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=JDBCUtil.getConnection();
			
			ps=con.prepareStatement(sql);
			
			for (int i = 0; i < params.length; i++) {
				setParam(i+1, params[i], ps);
			}
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		} finally {
			JDBCUtil.close(null, ps, null);
		}
	}
	
	public List query(String sql,RowMapper rm,Object... params){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=new ArrayList();
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				setParam(i+1, params[i], ps);
			}
			rs=ps.executeQuery();
			while(rs.next()){
				Object obj=rm.mapRow(rs);  //每一条记录转换成一个对象
				list.add(obj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		} finally {
			JDBCUtil.close(null, ps, rs);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	public void setParam(int index,Object param,PreparedStatement ps) throws Exception{
		if(param==null){
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
	
	
}
