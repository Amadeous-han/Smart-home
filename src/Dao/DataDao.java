package Dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Action.FamilyAction;
import Model.Type;
import Model.Data;
import Util.DBUtil;
import View.WetChart;
import Model.Equipment;

/**
 * ���ݿ�data����Ϣ���ݷ��ʶ�����,
 * ���������豸��id����ѯ������Ϣ
 * �����豸����ѯ������Ϣ
 * ���ݼ�ͥ����ͥ->�豸����ѯ��Ϣ
 * ĳ���豸��ĳ������ֵ���ڡ����ڡ�С��ĳ����ֵ�ĸ�������������ֵ
 * ĳ������ֵ�ķֲ�
 * �����ͥ�Ļ�������
 * �����������ݣ�data��
 * �����Ŵ��쳣����
 * @author 2019213421 190895833 ��˼��
 *
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Data;
import Util.DBUtil;
import Model.Equipment;

/**
 * ���ݿ�data����Ϣ���ݷ��ʶ�����,
 * ���������豸��id����ѯ������Ϣ
 * �����豸����ѯ������Ϣ
 * ���ݼ�ͥ����ͥ->�豸����ѯ��Ϣ
 * ĳ���豸��ĳ������ֵ���ڡ����ڡ�С��ĳ����ֵ�ĸ�������������ֵ
 * ĳ������ֵ�ķֲ�
 * �����ͥ�Ļ�������
 * �����������ݣ�data��
 * �����Ŵ��쳣����
 * @author 2019213421 190895833 ��˼��
 *
 */
public class DataDao {

		/**
		 * �����豸��ѯ����
		 */
		public ArrayList<Data> SearchByEquipment(String Eid,String start,String finish) throws Exception{
			//ȡ�������ݿ������
			Connection con = DBUtil.getConnection();
			ResultSet rs=null;
			String sql = "select * from Data" + " where equipment_idE = ? "
					+ "and time> ? "
					+ "and time< ? ";                     
			//Ԥ���� SQL ���
			PreparedStatement psmt = con.prepareStatement(sql);	      
			//��Ӳ���
			psmt.setString(1, Eid);
			psmt.setString(2, start);
			psmt.setString(3, finish);
			//ִ��
			rs=psmt.executeQuery();
			ArrayList<Data> dataList = new ArrayList<Data>();	       
			Data data = null;	   
			// ��������������ݣ��ͻ�ѭ����ӡ����
			while (rs.next()){	           
				data = new Data();	     
				data.setIdData(rs.getString("iddata"));	
				data.setWet(rs.getInt("wet"));	       
				data.setTemperature(rs.getInt("Temperature"));
				data.setLight(rs.getInt("light"));
				data.setEquipment_id(rs.getString("equipment_idE"));
				data.setTime(rs.getString("time"));
				data.setDataDelete(rs.getInt("datadelete"));
				if(rs.getInt("datadelete") > 0)
				dataList.add(data);	        
			}	 
			return dataList;
		}
		/**
		 * �����豸����ѯ����
		 * @return
		 * @��˼��
		 */
		public ArrayList<Data> SearchDataByType(String typeid,String start, String finish) throws Exception{
			//ȡ�������ݿ������
			Connection con = DBUtil.getConnection();
			ResultSet rs=null;
			String sql = "SELECT"
					+ " equipment_idE ,nameE AS name, "
					+ " iddata, wet,temperature,light,Ewindow,time,datadelete "
					+ "FROM equipment,data "
					+ "WHERE type_idType = ? AND equipment_idE = idE  "
					+ "and time> ? and time< ?";
			//Ԥ���� SQL ���
			PreparedStatement psmt = con.prepareStatement(sql);	      
			//��Ӳ���
			psmt.setString(1, typeid);
			psmt.setString(2, start);
			psmt.setString(3, finish);
			//ִ��
			rs=psmt.executeQuery();       
			ArrayList<Data> dataList = new ArrayList<Data>();	       
			Data data = null;	   
			// ��������������ݣ��ͻ�ѭ����ӡ����
			while (rs.next()){	           
				data = new Data();	     
				data.setIdData(rs.getString("iddata"));	
				data.setWet(rs.getInt("wet"));	       
				data.setTemperature(rs.getInt("Temperature"));
				data.setLight(rs.getInt("light"));
				data.setEquipment_id(rs.getString("equipment_idE"));
				data.setTime(rs.getString("time"));
				data.setDataDelete(rs.getInt("datadelete"));
				if(rs.getInt("datadelete") != 0)
				dataList.add(data);	        
			}
			return dataList;
		}
		/**
		 * ���ݼ�ͥ��ѯ����
		 * @return
		 * @author ��˼��
		 */
		public ArrayList<Data> SearchDataByFamily(String fid,String start, String finish) throws Exception{
			//ȡ�������ݿ������
					Connection con = DBUtil.getConnection();
					ResultSet rs=null;
					String sql = "SELECT"
							+ " Family_idFamily AS familyId,idE AS equipment_idE,nameE AS Ename,"
							+ " iddata, wet,temperature,light,Ewindow,time,datadelete "
							+ " FROM equipment, data "
							+ " WHERE Family_idFamily = ?"
							+ " and time> ? and time< ?"
							+ " AND equipment_idE = idE ";
					//Ԥ���� SQL ���
					PreparedStatement psmt = con.prepareStatement(sql);	      
					//��Ӳ���
					psmt.setString(1, fid);
					psmt.setString(2, start);
					psmt.setString(3, finish);
					//ִ��
					rs=psmt.executeQuery(); 
			ArrayList<Data> dataList = new ArrayList<Data>();	       
			Data data = null;	   
			// ��������������ݣ��ͻ�ѭ�������list����
			while (rs.next()){	           
				data = new Data();
				data.setFid(rs.getString("familyId"));
				data.setIdData(rs.getString("iddata"));	
				data.setWet(rs.getInt("wet"));	       
				data.setTemperature(rs.getInt("Temperature"));
				data.setLight(rs.getInt("light"));
				data.setEquipment_id(rs.getString("equipment_idE"));
				data.setEname(rs.getString("Ename"));
				data.setWindow(rs.getInt("Ewindow"));
				data.setTime(rs.getString("time"));
				data.setDataDelete(rs.getInt("datadelete"));
				if(rs.getInt("datadelete") != 0)
					dataList.add(data);	        
			}	 
			return dataList;
		}
		/**
		 * ĳ���豸��ĳ������ֵ���ڡ����ڡ�С��ĳ����ֵ�ĸ�������������ֵ
		 * @param args
		 * @throws SQLException 
		 * @throws Exception
		 */
	    public int getnumber ( String colname, String relation, String value,String equipment_Eid,
	    		                              String start, String finish) throws SQLException {
	    	
	    	//ȡ�������ݿ������
			Connection con = DBUtil.getConnection();
			ResultSet rs=null;
			String sql = "select "+colname
					//+ "COUNT(?) as number\r\n"
					+ " from mydb.data \r\n"
					+ "where "+colname +" "+relation+" "+value
					+ " and equipment_idE = ? "//+ equipment_Eid
					+ " and datadelete != 0\r\n"
					+ "and time> ?  and time <  ? ";
			//Ԥ���� SQL ���
			PreparedStatement psmt = con.prepareStatement(sql);	      
			//��Ӳ���
			psmt.setString(1, equipment_Eid);
			psmt.setString(2, start);
			psmt.setString(3, finish);
			//ִ��
			rs=psmt.executeQuery();
			ArrayList<Data> dataList = new ArrayList<Data>();	
			//Object data =new Object();
			Data data=null;
			int count=0;
			while(rs.next())  
	        {  
			    data = new Data();
	            data.setWet(rs.getInt(colname)) ;
	            dataList.add(data);
	            count++;
	        }  
	    	return count;
	    }
	    
	    /**
	     * ĳ������ֵ�ķֲ�
	     * @param args
	     * @throws SQLException 
	     * @throws Exception
	     */
	   public int[] wetdistribution(String start, String finish) throws SQLException {
	    	//ȡ�������ݿ������
	    		Connection con = DBUtil.getConnection();
	    		ResultSet rs=null;
	    		String sql = "SELECT \r\n"
	    				+ "    wet\r\n"
	    				+ "FROM\r\n"
	    				+ "    mydb.data\r\n"
	    				+ "WHERE\r\n"
	    				+ "    datadelete != 0\r\n"
	    				+ "    AND time > ?"
	    				+ "    AND time < ?";	
	    		//Ԥ���� SQL ���
	    		PreparedStatement psmt = con.prepareStatement(sql);	 
	    		psmt.setString(1,start);
	    		psmt.setString(2, finish);
	    		//execute
	    		rs=psmt.executeQuery();
	    		List<Data> dataList = new ArrayList<Data>();	       
	    		Data data = null;	    
	    		while(rs.next()) {
	    			data  = new Data();
	    			data.setWet(rs.getInt("wet"));
	    			dataList.add(data);
	    		}
	    		int[] count = new int[3];
	    		for (Data a : dataList) {
	                if(a.getWet() <= 30)
	                	count[0]++;
	                else if(a.getWet()>30 && a.getWet()<=60)
	                	count[1]++;
	                else if(a.getWet()>60 && a.getWet() <=100)
	                	count[2]++;
	            }
	    		
	    	return count;
	    }
	   public int[] tempdistribution(String start, String finish) throws SQLException {
	   	//ȡ�������ݿ������
	   		Connection con = DBUtil.getConnection();
	   		ResultSet rs=null;
	   		String sql = "SELECT \r\n"
	   				+ "    temperature\r\n"
	   				+ "FROM\r\n"
	   				+ "    mydb.data\r\n"
	   				+ "WHERE\r\n"
	   				+ "    datadelete != 0\r\n"
	   				+ "    AND time > ?"
	   				+ "    AND time < ?";	
	   		//Ԥ���� SQL ���
	   		PreparedStatement psmt = con.prepareStatement(sql);	 
	   		psmt.setString(1,start);
	   		psmt.setString(2, finish);
	   		//execute
	   		rs=psmt.executeQuery();
	   		List<Data> dataList = new ArrayList<Data>();	       
	   		Data data = null;	    
	   		while(rs.next()) {
	   			data  = new Data();
	   			data.setTemperature(rs.getInt("temperature"));
	   			dataList.add(data);
	   		}
	   		int[] count = new int[3];
	   		for (Data a : dataList) {
	               if(a.getTemperature() <= 30)
	               	count[0]++;
	               else if(a.getTemperature()>30 && a.getTemperature()<=60)
	               	count[1]++;
	               else if(a.getTemperature()>60 && a.getTemperature() <=100)
	               	count[2]++;
	           }	
	   	return count;
	   }
	   public int[] lightdistribution(String start, String finish) throws SQLException {
	   	//ȡ�������ݿ������
	   		Connection con = DBUtil.getConnection();
	   		ResultSet rs=null;
	   		String sql = "SELECT \r\n"
	   				+ "    light\r\n"
	   				+ "FROM\r\n"
	   				+ "    mydb.data\r\n"
	   				+ "WHERE\r\n"
	   				+ "    datadelete != 0\r\n"
	   				+ "    AND time > ?"
	   				+ "    AND time < ?";	
	   		//Ԥ���� SQL ���
	   		PreparedStatement psmt = con.prepareStatement(sql);	 
	   		psmt.setString(1,start);
	   		psmt.setString(2, finish);
	   		//execute
	   		rs=psmt.executeQuery();
	   		List<Data> dataList = new ArrayList<Data>();	       
	   		Data data = null;	    
	   		while(rs.next()) {
	   			data  = new Data();
	   			data.setLight(rs.getInt("light"));
	   			dataList.add(data);
	   		}
	   		int[] count = new int[3];
	   		for (Data a : dataList) {
	               if(a.getLight() <= 30)
	               	count[0]++;
	               else if(a.getLight()>30 && a.getLight()<=60)
	               	count[1]++;
	               else if(a.getLight()>60 && a.getLight() <=100)
	               	count[2]++;
	           }  		
	   	return count;
	   }
	    /**
	     * �����ͥ���ݻ���
	     * @param args
	     * @throws Exception
	     */
//	    public List<Data> summaryFamily(ArrayList<String> families) throws Exception{
//	    	
//	    	
//			return dataList;
//	    }
		// ���ص��Ƕ�ά���飬�ڲ��arraylist�����data��ͬһ���ڲ�ArrayList�����������ͬһ����ͥ
		@SuppressWarnings("rawtypes")
		public ArrayList searchByFamily(ArrayList<String> familyList, String start, String finish) 
				   throws Exception {
		    ArrayList<ArrayList> arrayList = new ArrayList<ArrayList>();
		    for(int i=0;i<familyList.size();i++){
		        arrayList.add(SearchDataByFamily(familyList.get(i), start, finish));
		    }
		    return arrayList;
		}
		/**
		 * ����data��Ϣ
		 */
	    public void adddata(Data data) throws Exception{
	    	// �����õ����ݿ������
	        Connection con = DBUtil.getConnection();
	        String sql="insert into data" 		
	        		+ "(iddata, wet, temperature, light, Ewindow, datadelete, equipment_idE, time) "
	        		+ " values(?,?,?,?,?,1,?,?)";
	        PreparedStatement psmt = con.prepareStatement(sql);
	        // �ȶ�ӦSQL��䣬��SQL��䴫�ݲ���
	        psmt.setString(1, data.getIdData());
	        psmt.setInt(2, data.getWet());
	        psmt.setInt(3, data.getTemperature());
	        psmt.setInt(4, data.getLight());
	        psmt.setInt(5, data.getWindow());
	        psmt.setString(6, data.getEquipment_id());
	        psmt.setString(7, data.getTime());
	        psmt.execute();
	    }
		
	    /**
	     * ɾ��data��Ϣ
	     */
	      public void deldata(String IdData) throws SQLException{
	    	  // �����õ����ݿ������
	          Connection con=DBUtil.getConnection();
	          String sql="" + 
	                  "update mydb.data "+               
	                  " set datadelete = 0"
	               + " where iddata = ?";
	          // Ԥ����sql���
	          PreparedStatement psmt = con.prepareStatement(sql);
	          // �ȶ�ӦSQL��䣬��SQL��䴫�ݲ���
	          psmt.setString(1, IdData);
	          // ִ��SQL���
	          psmt.execute();    
	      }
		    
		/**
		 * ����data��Ϣ
		 */
	    public void changedata(Data data) throws SQLException{
	    	// �����õ����ݿ������
	        Connection con=DBUtil.getConnection();
	        String sql="update mydb.data "
	        		+ " set wet = ?, temperature = ?, light =?, Ewindow = ?,"
	        		+ " datadelete = 1, equipment_idE = ?, time = ? "
	                // ������?��ʾ���൱��ռλ�� 
	        		+ " where iddata = ?";
	        // Ԥ����sql���
	        PreparedStatement psmt = con.prepareStatement(sql);
	        // �ȶ�ӦSQL��䣬��SQL��䴫�ݲ���
	        psmt.setInt(1, data.getWet());
	        psmt.setInt(2, data.getTemperature());
	        psmt.setInt(3, data.getLight());
	        psmt.setInt(4, data.getWindow());
	        psmt.setString(5, data.getEquipment_id());
	        psmt.setString(6, data.getTime());
	        psmt.setString(7,data.getIdData());
	        // ִ��SQL���
	        psmt.execute();    
	    }

		/**
		 * ��ѯȫ��data��Ϣ
		 */
		public List<Data> allData() throws Exception{	       
			Connection con = DBUtil.getConnection();	        
			Statement stmt = con.createStatement();	       
			ResultSet rs = stmt.executeQuery("select * from mydb.data");	      
			List<Data> dataList = new ArrayList<Data>();	       
			Data data = null;	   
			// ��������������ݣ��ͻ�ѭ����ӡ����
			while (rs.next()){	           
				data = new Data();	     
				data.setIdData(rs.getString("iddata"));	
				data.setWet(rs.getInt("wet"));	       
				data.setTemperature(rs.getInt("Temperature"));
				data.setLight(rs.getInt("light"));
				data.setEquipment_id(rs.getString("equipment_idE"));
				data.setTime(rs.getString("time"));
				data.setWindow(rs.getInt("Ewindow"));
				data.setDataDelete(rs.getInt("datadelete"));
				if(rs.getInt("datadelete") != 0)
				dataList.add(data);	        
			}	       
			return dataList;	  
		}
		public List<Data> allDataid() throws Exception{	       
			Connection con = DBUtil.getConnection();	        
			Statement stmt = con.createStatement();	       
			ResultSet rs = stmt.executeQuery("select iddata from mydb.data");	      
			List<Data> dataList = new ArrayList<Data>();	       
			Data data = null;	   
			// ��������������ݣ��ͻ�ѭ����ӡ����
			while (rs.next()){	           
				data = new Data();	     
				data.setIdData(rs.getString("iddata"));	
				dataList.add(data);	        
			}	       
			return dataList;	  
		}
//		public static void main(String[] args) throws Exception {
//			DataDao a = new DataDao();
//			int dataList=a.getnumber("wet", ">", "0" ,"387900","2010-01-10_00:40:36","2021-07-21_18:00:00");
//		    FamilyAction f=new FamilyAction();
//	        for (int i = 0; i < f.findTableID().size(); i++) {
//	            System.out.println(f.findTableID().get(i));
//	        }
//		    //��ͥidû������
//			ArrayList data=a.searchByFamily(f.findTableID(), "2010-01-10_00:40:36", "2021-07-21_18:00:00");
////	        for (Data goddess : dataList) {
////	            System.out.println(goddess.getNumber());
////	        }
//			Object[][] results=new Object[f.findTableID().size()][9];
//	        for (int i = 0; i < data.size(); i++) {
//	        	for(int j = 0;j< ((ArrayList<Data>) data.get(i)).size();j++)
//	            {System.out.println(((ArrayList<Data>) data.get(i)).get(j).getFid()+" "+((ArrayList<Data>) data.get(i)).get(j).getWet());
//	            }
//	        }
//	        System.out.println(dataList);
//	        int[] count = a.tempdistribution("2010-01-10_00:40:36", "2021-07-21_18:00:00");
//	        WetChart B= new WetChart(count);
//			 B.chart(count);
//			 System.out.println(count[0] +" " + count[1] +" "+ count[2]);
//		}
		}
