package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//�������ݿ��࣬����һ�������ṩ��ȡ���ݿ����ӵķ���
public class DBUtil {
	// ���ݿ�����·��
//		private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_books?"
//				+ "useUnicode = true & serverTimezone = GMT"
//				// MySQL�ڸ߰汾��Ҫָ���Ƿ����SSL����
//				+ "& characterEncoding = utf8 & useSSL = false";
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	
	private static final String NAME = "root";
		private static final String PASSWORD = "2000108";
		private static Connection conn = null;
		
		// ��̬����飨�������������������ݿ���뾲̬���У�
		 static{
		        try {
		            // ������������
		        	Class.forName(JDBC_DRIVER);
		            // ��ȡ���ݿ������
		            conn = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		 
		 // �����ṩһ����������ȡ���ݿ�����	    
		 public static Connection getConnection(){     
			 return conn;	   
		 }
		
		
}
