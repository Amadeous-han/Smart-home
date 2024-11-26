package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Vendor;
import Util.DBUtil;

public class VendorDao {
	public List<Vendor> query() throws Exception{	       
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("SELECT idVendor,VendorName,AES_DECRYPT(UNHEX(Vcode), 'key') FROM mydb.vendor");	      
		List<Vendor> vendorList = new ArrayList<Vendor>();	       
		Vendor vendor = null;	   
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	
			vendor = new Vendor();	     
			vendor.setID(rs.getString("idVendor"));
			vendor.setVname(rs.getString("VendorName"));	 
			vendor.setVCode(rs.getString("AES_DECRYPT(UNHEX(Vcode), 'key')"));   
			vendorList.add(vendor);
		}	       
		return vendorList;	  
	}
}
