import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class Test2 {
	public static void main(String[] args) throws Exception {
		Properties p=new Properties();
		p.load(Test2.class
					.getClassLoader()
					.getResourceAsStream("dataSource.properties"));
		DataSource dataSource=BasicDataSourceFactory.createDataSource(p);
		
		
		Connection con=dataSource.getConnection();
		System.out.println(con);
		con.close();
		
		
		
		
		
		
		
		
		
	}
}
