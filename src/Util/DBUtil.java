package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//连接数据库类，包含一个对外提供获取数据库连接的方法
public class DBUtil {
	// 数据库连接路径
//		private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_books?"
//				+ "useUnicode = true & serverTimezone = GMT"
//				// MySQL在高版本需要指明是否进行SSL连接
//				+ "& characterEncoding = utf8 & useSSL = false";
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	
	private static final String NAME = "root";
		private static final String PASSWORD = "2000108";
		private static Connection conn = null;
		
		// 静态代码块（将加载驱动、连接数据库放入静态块中）
		 static{
		        try {
		            // 加载驱动程序
		        	Class.forName(JDBC_DRIVER);
		            // 获取数据库的连接
		            conn = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		 
		 // 对外提供一个方法来获取数据库连接	    
		 public static Connection getConnection(){     
			 return conn;	   
		 }
		
		
}
