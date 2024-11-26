package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Administration;
import Util.DBUtil;

public class AdministrationDao {
	public List<Administration> query() throws Exception{	       
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("select idAdministration,AES_DECRYPT(UNHEX(Acode), 'key'),Aname from mydb.administration");	      
		List<Administration> administrationList = new ArrayList<Administration>();	       
		Administration administration = null;	   
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	
			administration = new Administration();	     
			administration.setID(rs.getString("idAdministration"));
			administration.setACode(rs.getString("AES_DECRYPT(UNHEX(Acode), 'key')"));	 
			administration.setAname(rs.getString("Aname"));   
			administrationList.add(administration);
		}	       
		return administrationList;	  
	}
}
