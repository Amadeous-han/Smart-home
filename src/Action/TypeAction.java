package Action;

import java.util.List;

import javax.swing.*;

import Dao.TypeDao;
import Model.Equipment;
import Model.Type;

public class TypeAction {
	public Object[][] initializTable(String[] columnNames) throws Exception{
		TypeDao typeDao = new TypeDao();
		List list = typeDao.query();
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {
			Type type = (Type)list.get(i);				
			if(type.getDelete()!=0) {
				//System.out.println(type.getDelete());
			results[i][0] = type.getID();
			results[i][1] = type.getTName();
			}
		}	   	
		return results;
	}
	public String[] findTable(Object[][] results,String Id) throws Exception{
		String[] tar = {"Not Found","","","","","","",""};
		for(int i=0;results[i][0]!=null;i++)
		{
			if( ((String) results[i][0]).compareTo(Id)==0)
			{
				tar[0]=(String) results[i][0];
				tar[1]=(String) results[i][1];
			}
		}
		return tar;
	}
	public void addType(JTextField textTname,JTextField textTid)throws Exception {
		TypeDao typeDao=new TypeDao();
		Type type=new Type();
		type.setID(textTid.getText());
		type.setTname(textTname.getText());
		type.setDelete(1);
		//添加类型
		typeDao.addType(type);
	}
	//选中行删除
	public void delType(JTable table) throws Exception {
		
		int selRow = table.getSelectedRow();
		String ID = table.getValueAt(selRow, 0).toString();
		
        TypeDao typeDao=new TypeDao();
        Type type=new Type();     
        Equipment equipment=new Equipment();
        type.setID(ID);
   
        // 删除图书信息 

        type.setDelete(0);
        typeDao.delType(type,equipment);
        
	}
	//选中行修改
	public void changeType(JTable table,JTextField textTname) throws Exception {
		if(table.getSelectedRow()<0)
		{
			JOptionPane.showMessageDialog(null,"请先选中想要更改的设备","错误"
					, JOptionPane.PLAIN_MESSAGE);
		}
		int selRow = table.getSelectedRow();
		String ID = table.getValueAt(selRow, 0).toString();
		
        TypeDao typeDao=new TypeDao();
        Type type=new Type();     
        
        type.setID(ID);
   
        // 修改图书信息
		type.setTname(textTname.getText());
        typeDao.changeType(type);

	}
}
