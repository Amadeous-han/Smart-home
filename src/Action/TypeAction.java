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
		//�������
		typeDao.addType(type);
	}
	//ѡ����ɾ��
	public void delType(JTable table) throws Exception {
		
		int selRow = table.getSelectedRow();
		String ID = table.getValueAt(selRow, 0).toString();
		
        TypeDao typeDao=new TypeDao();
        Type type=new Type();     
        Equipment equipment=new Equipment();
        type.setID(ID);
   
        // ɾ��ͼ����Ϣ 

        type.setDelete(0);
        typeDao.delType(type,equipment);
        
	}
	//ѡ�����޸�
	public void changeType(JTable table,JTextField textTname) throws Exception {
		if(table.getSelectedRow()<0)
		{
			JOptionPane.showMessageDialog(null,"����ѡ����Ҫ���ĵ��豸","����"
					, JOptionPane.PLAIN_MESSAGE);
		}
		int selRow = table.getSelectedRow();
		String ID = table.getValueAt(selRow, 0).toString();
		
        TypeDao typeDao=new TypeDao();
        Type type=new Type();     
        
        type.setID(ID);
   
        // �޸�ͼ����Ϣ
		type.setTname(textTname.getText());
        typeDao.changeType(type);

	}
}
