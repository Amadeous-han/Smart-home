package Action;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Dao.EquipmentDao;
import Model.Equipment;
public class EquipmentAction {
	public Object[][] initializTable(String[] columnNames) throws Exception{
		EquipmentDao equipmentDao = new EquipmentDao();
		List list = equipmentDao.query();
		Object[][] results = new Object[list.size()][columnNames.length+1];
		
		for(int i = 0; i < list.size(); i++) {
			Equipment equipment = (Equipment)list.get(i);				
	      if(equipment.getDelete()!=0) {
			results[i][0] = equipment.getID();
			results[i][1] = equipment.getEName();
			results[i][2] = equipment.getFunction();
			results[i][3] = equipment.getFID();
			results[i][4] = equipment.getTID();
			results[i][5] = equipment.getVID();
			results[i][6] = equipment.getDelete();
	
	      }
		}	   	
		return results;
	}
	public Object[][] findTable(Object[][] results,String VId) throws Exception{
		EquipmentDao equipmentDao = new EquipmentDao();
		List list = equipmentDao.query();
		int j=0;
		for(int i=0; i < list.size();i++)
		{
			if( results[i][5].toString().compareTo(VId)==0)
			{
				j++;
			}
				
		}
		Object[][] tar = new Object[j][7];
		j=0;
		for(int i=0; i < list.size();i++)
		{
			if( results[i][5].toString().compareTo(VId)==0)
			{
				tar[j][0]= results[i][0].toString();
				tar[j][1]= results[i][1].toString();
				tar[j][2]= results[i][2].toString();
				tar[j][3]= results[i][3].toString();
				tar[j][4]= results[i][4].toString();
				tar[j][5]= results[i][5].toString();
				tar[j][6]= results[i][6].toString();
				j++;
			}
				
		}
		return tar;
	}
	public Object[][] findTable2(Object[][] results,String Id) throws Exception{
		Object[][] tar = new Object[1][7];
		EquipmentDao equipmentDao = new EquipmentDao();
		List list = equipmentDao.query();
		for(int i=0;i < list.size();i++)
		{
			if( (results[i][0]).toString().compareTo(Id)==0)
			{
				tar[1][0]= results[i][0].toString();
				tar[1][1]= results[i][1].toString();
				tar[1][2]= results[i][2].toString();
				tar[1][3]= results[i][3].toString();
				tar[1][4]= results[i][4].toString();
				tar[1][5]= results[i][5].toString();
				tar[1][6]= results[i][6].toString();
			}
		}
		return tar;
	}
	public void addEquipment(JTextField textId,JTextField textEName,JTextField textEfunc,JTextField textFid,JTextField textTID,JTextField textVID)throws Exception {
		EquipmentDao equipmentDao=new EquipmentDao();
		Equipment equipment=new Equipment();
		equipment.setID(textId.getText());
		equipment.setEname(textEName.getText());
		equipment.setFunction(textEfunc.getText());
		equipment.setFID(textFid.getText());
		equipment.setTID(textTID.getText());
		equipment.setVID(textVID.getText());
		equipment.setDelete(1);
		//添加类型
		equipmentDao.addEquipment(equipment);
	}
public void delEquipment(JTable table) throws Exception {
		
		int selRow = table.getSelectedRow();
		String ID = table.getValueAt(selRow, 0).toString();
		
        EquipmentDao equipmentDao=new EquipmentDao();
        Equipment equipment=new Equipment();     
        
        equipment.setID(ID);
   


        equipment.setDelete(0);
        equipmentDao.delEquipment(equipment);
        
	}
	//选中行修改
		public void changeEquipment(JTable table,JTextField textEName,JTextField textEfunc,JTextField textFid,JTextField textTID,JTextField textVID) throws Exception {
			if(table.getSelectedRow()<0)
			{
				JOptionPane.showMessageDialog(null,"请先选中想要更改的设备","错误"
						, JOptionPane.PLAIN_MESSAGE);
			}
			int selRow = table.getSelectedRow();
			String ID = table.getValueAt(selRow, 0).toString();

	        EquipmentDao equipmentDao=new EquipmentDao();
	        Equipment equipment=new Equipment();     
	        
	        equipment.setID(ID);
	        if(textEName.getText()!="")
			equipment.setEname(textEName.getText());
	        if(textEfunc.getText()!="")
			equipment.setFunction(textEfunc.getText());
	        if(textFid.getText()!="")
			equipment.setFID(textFid.getText());
	        if(textTID.getText()!="")
			equipment.setTID(textTID.getText());
	        if(textVID.getText()!="")
			equipment.setVID(textVID.getText());
	       equipmentDao.changeEquipment(equipment);
		}

}
