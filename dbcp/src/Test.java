import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;


public class Test {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=utf8";
	private static String username="root";
	private static String password="root";
	
	public static void main(String[] args) throws Exception {
		
		
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		//最大连接数
		dataSource.setMaxActive(1);
		//初始化连接数
		dataSource.setInitialSize(1);
		//最长等待时间
		dataSource.setMaxWait(5000);
		
		
		Connection con=dataSource.getConnection();
		
		System.out.println(con);
		System.out.println(con.hashCode());
		
		//把连接还给连接池
		con.close();
		
		Connection con2=dataSource.getConnection();
		
		System.out.println(con2);
		System.out.println(con2.hashCode());
		
		
		Connection con3=dataSource.getConnection();
		
		System.out.println(con3);
		System.out.println(con3.hashCode());
		//把连接还给连接池
		con2.close();
		
		
		
		
		
		
		
		
		
	}
}
