package Action;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import Model.Data;
import Dao.DataDao;
import data.genData;


public class DataAction {
	/**
	 * 初始化窗体表格
	 * @return results
	 */
	@SuppressWarnings("rawtypes")
	public Object[][] initializTable(String[] columnNames) throws Exception{
		DataDao dataDao = new DataDao();
		List list = dataDao.allData();
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {
			Data data = (Data)list.get(i);				
			results[i][0] = data.getIdData();
			results[i][1] = data.getWet();
			results[i][2] = data.getTemperature();
			results[i][3] = data.getLight();
			results[i][4] = data.getWindow();
			results[i][5] = data.getEquipment_id();
			results[i][6] = data.getTime();	
		    }	   	
		return results;
}
	/**
	 * 添加数据  微调11：43
	 */
	public void addDataInfo( JTextField textFieldWet, JTextField textFieldTemp,
			                         JTextField textFieldLight, JTextField textFieldWindow, JTextField textFieldEid
			                         ) throws Exception{
		    DataDao dataDao=new DataDao();
	        Data data=new Data(); 
	        genData r = new genData();
	        //get a random id
	        int flag = 0;
	        String id = r.randomId(8);
	        List<Data> dataList=dataDao.allData();
	        do {
	        for (Data goddess : dataList) {
	            if(goddess.getIdData().equals(id)) {
	            	 flag = 1;
	            	 id = r.randomId(8);
	            	 break;
	            }
	        }
	        }while(flag == 1);
	        data.setIdData(id);
	        int wet = Integer.parseInt(textFieldWet.getText());
	        data.setWet(wet);
	        int Temp = Integer.parseInt(textFieldTemp.getText());
	        data.setTemperature(Temp);
	        int Light = Integer.parseInt(textFieldLight.getText());
	        data.setLight(Light);
	        int Window = Integer.parseInt(textFieldWindow.getText());
	        data.setWindow(Window);
	        data.setEquipment_id(textFieldEid.getText());
	        LocalDateTime dateTime = LocalDateTime.now(); 
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");  
	        System.out.println(dateTime.format(formatter)); 
	        data.setTime(dateTime.format(formatter));
	        //添加图书
	        dataDao.adddata(data);
		}
	/**
	 * 删除数据
	 */
		public void delData (JTable table) throws Exception {
			
			int selRow = table.getSelectedRow();
			String ID = table.getValueAt(selRow, 0).toString();
	        DataDao dataDao=new DataDao();
	        Data data=new Data();      
	        data.setDataDelete(0);
	        // 删除信息
	        dataDao.deldata(ID);	
	}
		/**
		 * 修改data信息
		 */
		public void changeDataInfo(JTextField textFieldWet, JTextField textFieldTemp
				,JTextField textFieldLight, JTextField textFieldWindow, JTextField textFieldEid
				,JTextField textFieldTime,JTable table) throws Exception{
			
	        DataDao dataDao=new DataDao();
	        Data data=new Data();     
	       
			int selRow = table.getSelectedRow();
			String ID = table.getValueAt(selRow, 0).toString();	
	        data.setIdData(ID);
	        int wet = Integer.parseInt(textFieldWet.getText());
	        data.setWet(wet);
	        int Temp = Integer.parseInt(textFieldTemp.getText());
	        data.setTemperature(Temp);
	        int Light = Integer.parseInt(textFieldLight.getText());
	        data.setLight(Light);
	        int Window = Integer.parseInt(textFieldWindow.getText());
	        data.setWindow(Window);
	        data.setEquipment_id(textFieldEid.getText());
	        LocalDateTime dateTime = LocalDateTime.now(); 
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");  
	        data.setTime(dateTime.format(formatter)); 
	        //修改图书
	        dataDao.changedata(data);       
		}
		/**
		 * 根据设备查阅信息
		 * @throws Exception 
		 */
		public Object[][] getTable(String[] columnNames,JTextField Eid, JTextField start, JTextField finish) throws Exception{
			DataDao dataDao=new DataDao();
			ArrayList<Data> list = dataDao.SearchByEquipment(Eid.getText(), start.getText(),finish.getText());
			Object[][] results = new Object[list.size()][columnNames.length];
			
			for(int i = 0; i < list.size(); i++) {
				Data data = (Data)list.get(i);				
				results[i][0] = data.getIdData();
				results[i][1] = data.getWet();
				results[i][2] = data.getTemperature();
				results[i][3] = data.getLight();
				results[i][4] = data.getWindow();
				results[i][5] = data.getEquipment_id();
				results[i][6] = data.getTime();	
			    }	   	
			return results;
	}
		/**
		 * 根据设备类别查询信息
		 * @throws Exception 
		 */
		public Object[][] getTableByType(String[] columnNames,JTextField Type, JTextField start, JTextField finish) throws Exception{
			DataDao dataDao=new DataDao();
			ArrayList<Data> list = dataDao.SearchDataByType(Type.getText(), start.getText(),finish.getText());
			Object[][] results = new Object[list.size()][columnNames.length];
			
			for(int i = 0; i < list.size(); i++) {
				Data data = (Data)list.get(i);				
				results[i][0] = data.getIdData();
				results[i][1] = data.getWet();
				results[i][2] = data.getTemperature();
				results[i][3] = data.getLight();
				results[i][4] = data.getWindow();
				results[i][5] = data.getEquipment_id();
				results[i][6] = data.getTime();	
			    }	   	
			return results;
	}
		 /**
		  * 根据家庭查询信息
		  */
		public Object[][] getTableByFamily(String[] columnNames,JTextField family, JTextField start, JTextField finish) throws Exception{
			DataDao dataDao=new DataDao();
			ArrayList<Data> list = dataDao.SearchDataByFamily(family.getText(), start.getText(),finish.getText());
			Object[][] results = new Object[list.size()][columnNames.length];
			
			for(int i = 0; i < list.size(); i++) {
				Data data = (Data)list.get(i);
				results[i][0] = data.getFid();
				results[i][1] = data.getIdData();
				results[i][2] = data.getWet();
				results[i][3] = data.getTemperature();
				results[i][4] = data.getLight();
				results[i][5] = data.getWindow();
				results[i][6] = data.getEquipment_id();
				results[i][7] = data.getEname();
				results[i][8] = data.getTime();	
			    }	   	
			return results;
	}
		/**
		 * 获得wet在规定时间内的分布
		 * @throws SQLException 
		 */
		public int[] getDisOfWet(JTextField startTime, JTextField finishTime) throws SQLException {
			DataDao dataDao = new DataDao();
			int[] num = dataDao.wetdistribution(startTime.getText(), finishTime.getText());
			return num;
		}
		/**
		 * 获得TEmp在规定时间内的分布
		 * @throws SQLException 
		 */
		public int[] getDisOfTemp(JTextField startTime, JTextField finishTime) throws SQLException {
			DataDao dataDao = new DataDao();
			int[] num = dataDao.tempdistribution(startTime.getText(), finishTime.getText());
			return num;
		}
		/**
		 * 获得Light在规定时间内的分布
		 * @throws SQLException 
		 */
		public int[] getDisOfLight(JTextField startTime, JTextField finishTime) throws SQLException {
			DataDao dataDao = new DataDao();
			int[] num = dataDao.lightdistribution(startTime.getText(), finishTime.getText());
			return num;
		}
		/**
		 * 某个设备的某个测量值大于、等于、小于某个数值的个数
		 * @param textFieldColName
		 * @param textFieldValue
		 * @param textFieldEquipmentID
		 * @param textFieldStartTime
		 * @param textFieldFinishTime
		 * @param comboBox
		 * @return
		 * @throws SQLException
		 */
		public int dataRelation(JTextField textFieldColName, JTextField textFieldValue,JTextField 
				textFieldEquipmentID, JTextField textFieldStartTime, JTextField textFieldFinishTime , 
				JComboBox<String> comboBox  ) throws SQLException {
			DataDao dataDao = new DataDao();
			int m = dataDao.getnumber(textFieldColName.getText(), (String) comboBox.getSelectedItem(), 
					textFieldValue.getText(), textFieldEquipmentID.getText(), textFieldStartTime.getText(), 
					textFieldFinishTime.getText());
			return m;
		}
		
	}

