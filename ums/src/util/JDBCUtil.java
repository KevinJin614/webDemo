package util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import exception.DataAccessException;

public class JDBCUtil {
	private static DataSource dataSource;
	private static ThreadLocal<Connection> threadLocal;
	static{
		threadLocal=new ThreadLocal<Connection>();
		Properties p=new Properties();
		try {
			p.load(JDBCUtil.class
						.getClassLoader()
						.getResourceAsStream("dataSource.properties"));
			dataSource=BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("JDBCUtil初始化错误"+e.getMessage());
		}
	}
	
	//一个业务一个事物，一个事物一个连接，一个连接一个线程
	public static Connection getConnection(){
		Connection con=null;
		try {
			//从缓存中获得当前线程的connection
			con=threadLocal.get();
			//如果con==null
			if(con==null){
				con=dataSource.getConnection();
				//将connection放入缓存中
				threadLocal.set(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}
		return con;
	}
	
	
	
	public static void close(Connection con,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//关闭跟本线程相关的连接
	public static void close(){
		Connection con=null;
		try {
			con=threadLocal.get();
			if(con!=null){
				con.close();
				threadLocal.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(JDBCUtil.getConnection().hashCode());
		
		System.out.println(JDBCUtil.getConnection().hashCode());
		
		System.out.println(JDBCUtil.getConnection().hashCode());
		
		f();
		
		new Thread(){
			@Override
			public void run() {
				System.out.println(JDBCUtil.getConnection().hashCode());
				System.out.println(JDBCUtil.getConnection().hashCode());
				System.out.println(JDBCUtil.getConnection().hashCode());
				System.out.println(JDBCUtil.getConnection().hashCode());
			}
		}.start();
	}
	
	
	public static void f(){
		System.out.println(JDBCUtil.getConnection().hashCode());
	}
	
	
	
}
