package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Equipment;
import Model.Family;
import Model.User;
import Util.DBUtil;

public class FamilyDao {
	public void addFamily(Family family) throws Exception{
        Connection con = DBUtil.getConnection();
        String sql="INSERT INTO mydb.family (idFamily,Fname,fdelete) VALUES (?, ?,?)";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, family.getID());
        if (family.getFName() == null || family.getID()== "") {
    	psmt.setString(2 ,null);
        }
        else {
    	  psmt.setString(2, family.getFName());
        }
        psmt.setInt(3, family.getDelete());
        psmt.execute();
	}
	public void delFamily(Family family,Equipment equipment,User user) throws Exception{
		Connection con=DBUtil.getConnection();
		String sql="update mydb.family set fdelete =? where idFamily  = ?; ";
		String sql2="update mydb.users u, mydb.equipment e set Udelete = ? , Edelete = ? where e.Family_idFamily = ? and u.family_idfamily = ?  ";
		//String sql="UPDATE mydb.family SET fdelete = ? WHERE idFamily= ? ";
		 PreparedStatement psmt = con.prepareStatement(sql);
		 PreparedStatement psmt2 = con.prepareStatement(sql2);
		 psmt.setInt(1, family.getDelete());
		 psmt.setString(2, family.getID());
		 psmt.execute();
		 psmt2.setInt(1, user.getDelete());
		 psmt2.setInt(2, equipment.getDelete());
		 psmt2.setString(3, family.getID());
		 psmt2.setString(4, family.getID());
		 psmt2.execute();
	}
	public void changeFamily(Family family) throws Exception{
		 Connection con=DBUtil.getConnection();
		 String sql="UPDATE mydb.family SET Fname = ? WHERE idFamily= ? ";
		 PreparedStatement psmt = con.prepareStatement(sql);
	     if (family.getFName() == null || family.getID()== "") {
	        	psmt.setString(1 ,null);
	            }
	     else {
	        	  psmt.setString(1, family.getFName());
	            }
		 psmt.setString(2, family.getID());
		 psmt.execute();
	}
	public List<Family> query() throws Exception{
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("SELECT idFamily,Fname,fdelete FROM mydb.family");	      
		List<Family> familyList = new ArrayList<Family>();	       
		Family family = null;	   
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	
			if(rs.getInt("Fdelete")!=0) {
			family = new Family();	     
			family.setID(rs.getString("idFamily"));
			family.setFName(rs.getString("Fname"));
			family.setDelete(rs.getInt("fdelete"));
			familyList.add(family);
			}
		}	       
		return familyList;	  
	}
}
