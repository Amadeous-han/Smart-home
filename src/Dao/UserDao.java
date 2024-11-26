package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import Util.DBUtil;

public class UserDao {
	public void addUser(User user) throws Exception{
		// 首先拿到数据库的连接
        Connection con = DBUtil.getConnection();
        String sql="INSERT INTO mydb.users (idusers,username,userscode,family_idfamily,Udelete,sex) VALUES (?, ?,hex(AES_ENCRYPT(?,'key')),?,?,?)";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, user.getID());
        psmt.setString(2, user.getUName());
        psmt.setString(3, user.getUCode());
        psmt.setString(4, user.getFID());
        psmt.setInt(5, user.getDelete());
        psmt.setString(6, user.getGender());
        psmt.execute();
	}
	public void delUser(User user) throws SQLException{
  	  // 首先拿到数据库的连接
        Connection con=DBUtil.getConnection();
        String sql="UPDATE mydb.users SET Udelete = ? WHERE idusers= ? ";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setInt(1,  user.getDelete());
        psmt.setString(2, user.getID());
        psmt.execute();
	}
	
	public void changeUser(User user) throws SQLException{
		 Connection con=DBUtil.getConnection();
		 String sql="UPDATE mydb.users SET username = ?, userscode =? , family_idfamily = ?, sex = ? WHERE idusers= ? ";
	        PreparedStatement psmt = con.prepareStatement(sql);//hex(AES_ENCRYPT(?,'key'))
	        psmt.setString(1, user.getUName());
	        psmt.setString(2, user.getUCode());
	        psmt.setString(3, user.getFID());
	        psmt.setString(4, user.getGender());
	        psmt.setString(5, user.getID());
	        psmt.execute();
	}
	public List<User> query() throws Exception{	       
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("SELECT idusers,username,userscode,family_idfamily,Udelete,sex FROM mydb.users");	      
		List<User> userList = new ArrayList<User>();	     //AES_DECRYPT(UNHEX(userscode), 'key')  
		User user = null;	   
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	
			if(rs.getInt("Udelete")!=0) {
				user = new User();	     
				user.setID(rs.getString("idusers"));
				user.setUName(rs.getString("username"));
				user.setUCode(rs.getString("userscode"));//AES_DECRYPT(UNHEX(userscode), 'key')
				user.setFID(rs.getString("family_idfamily"));	       
				user.setGender(rs.getString("sex"));
				user.setDelete(rs.getInt("Udelete"));
			userList.add(user);
			}
		}	       
		return userList;	  
	}
}
