package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import exception.DataAccessException;

public class JDBCUtil {
	public static DataSource dataSource;
	static{
		Properties p = new Properties();
		try {
			p.load(JDBCUtil.class
						   .getClassLoader()
						   .getResourceAsStream("dataSource.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("JDBCUtil初始化错误"+e.getMessage());
		}
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}
		return con;
	}
	
	public static void close(Connection con , PreparedStatement ps ,ResultSet rs){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
}
