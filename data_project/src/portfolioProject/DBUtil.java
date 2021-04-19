package portfolioProject;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	
	
	public static Connection getConnection() throws Exception
	{
		
		Properties properties = new Properties();
		String filePath = DBUtil.class.getResource("db.propertise").getPath();
		filePath = URLDecoder.decode(filePath, "utf-16");
		properties.load(new FileReader(filePath));
		
		String MYSQL_DRIVER = properties.getProperty("MYSQL_DRIVER");
		String URL = properties.getProperty("URL");
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		
		
		
		Class.forName(MYSQL_DRIVER);
		
		Connection connection = DriverManager.getConnection(URL+"?useSSL=false", userName, password);
				
		return connection;
	}
	
}
