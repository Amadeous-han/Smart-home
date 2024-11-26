package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Equipment;
import Util.DBUtil;
//Equipment Efunction 名称有问题改了
public class EquipmentDao {
	public void addEquipment(Equipment equipment) throws Exception{
		// 首先拿到数据库的连接
        Connection con = DBUtil.getConnection();
        String sql="insert into mydb.equipment (idE,nameE,Family_idFamily,Vendor_idVendor,Efunction,type_idType,Edelete)values(?,?,?,?,?,?,?)";
        		/*
        		 * 参数用?表示，相当于占位符，然后在对参数进行赋值。当真正执行时，
        		 * 这些参数会加载在SQL语句中，把SQL语句拼接完整才去执行。这样就会减少对数据库的操作
        		 */
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, equipment.getID());
        psmt.setString(2, equipment.getEName());
        psmt.setString(3, equipment.getFID());
        psmt.setString(4, equipment.getVID());
        psmt.setString(5, equipment.getFunction());
        psmt.setString(6, equipment.getTID());
        psmt.setInt(7, equipment.getDelete());
//        if (equipment.getDelete() == null || equipment.getID()== "") {
//        	psmt.setString(7, null);
//        }
//        else {
//        	  psmt.setString(7, equipment.getID());
//        }
        //执行SQL语句
        psmt.execute();
	}
	public void delEquipment(Equipment equipment) throws SQLException{
  	  // 首先拿到数据库的连接
        Connection con=DBUtil.getConnection();
        String sql="update  mydb.equipment set Edelete = ? WHERE idE = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setInt(1,  equipment.getDelete());
        psmt.setString(2, equipment.getID());
        psmt.execute();
	}
	
	public void changeEquipment(Equipment equipment) throws SQLException{
		 Connection con=DBUtil.getConnection();
		 String sql="update  mydb.equipment set nameE=?,Family_idFamily=?,Vendor_idVendor=?,Efunction=?,type_idType=? WHERE idE = ?";
	        PreparedStatement psmt = con.prepareStatement(sql);
	        psmt.setString(1, equipment.getEName());
	        psmt.setString(2, equipment.getFID());
	        psmt.setString(3, equipment.getVID());
	        psmt.setString(4, equipment.getFunction());
	        psmt.setString(5, equipment.getTID());
	        psmt.setString(6, equipment.getID());
	        psmt.execute();
	}
	public List<Equipment> query() throws Exception{	       
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("select "
				+ "idE,nameE,Family_idFamily,Vendor_idVendor,Efunction,type_idType,Edelete "
				+ "from mydb.equipment");	      
		List<Equipment> equipmentList = new ArrayList<Equipment>();	       
		Equipment equipment = null;	   
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	
			if(rs.getInt("Edelete")!=0) {
			equipment = new Equipment();	     
			equipment.setID(rs.getString("idE"));
			equipment.setEname(rs.getString("nameE"));
			equipment.setFID(rs.getString("Family_idFamily"));	       
			equipment.setVID(rs.getString("Vendor_idVendor"));
			equipment.setFunction(rs.getString("Efunction"));
			equipment.setTID(rs.getString("type_idType"));
			equipment.setDelete(rs.getInt("Edelete"));
			equipmentList.add(equipment);
			}
		}	       
		return equipmentList;	  
	}
}
