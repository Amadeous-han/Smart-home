package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Equipment;
import Model.Type;
import Util.DBUtil;
//delete项设置成非空
public class TypeDao {
	public void addType(Type type) throws Exception{
        Connection con = DBUtil.getConnection();
        String sql="INSERT INTO mydb.type (idType,Typename,Tdelete) VALUES (?, ?,?);";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, type.getID());
        psmt.setString(2, type.getTName());
        psmt.setInt(3, type.getDelete());
        psmt.execute();
	}
	public void delType(Type type,Equipment equipment) throws Exception{
		Connection con=DBUtil.getConnection();
		String sql="UPDATE mydb.type SET Tdelete = ? WHERE idType= ? ";
		String sql2="update equipment\r\n"
				+ "		set  Edelete = ?\r\n"
				+ "		where type_idType = ? ; ";
		
		 PreparedStatement psmt = con.prepareStatement(sql);
		 PreparedStatement psmt2 = con.prepareStatement(sql2);
		 psmt.setInt(1, type.getDelete());
		 psmt.setString(2, type.getID());
		 psmt.execute();
		 psmt2.setInt(1, equipment.getDelete());
		 psmt2.setString(2, equipment.getID());
		 psmt2.execute();
		 
	}
	public void changeType(Type type) throws Exception{
		 Connection con=DBUtil.getConnection();
		 String sql="UPDATE mydb.type SET Typename = ? WHERE idType= ? ";
		 PreparedStatement psmt = con.prepareStatement(sql);
		 psmt.setString(1, type.getTName());
		 psmt.setString(2, type.getID());
		 psmt.execute();
	}
	public List<Type> query() throws Exception{
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("SELECT idType,Typename,Tdelete FROM mydb.type");	      
		List<Type> typeList = new ArrayList<Type>();	       
		Type type = null;	   
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	
			if(rs.getInt("Tdelete")!=0) {
			type = new Type();	     
			type.setID(rs.getString("idType"));
			type.setTname(rs.getString("Typename"));
			type.setDelete(rs.getInt("Tdelete"));
			typeList.add(type);
			}
		}	       
		return typeList;	  
	}
}
