package Action;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Dao.FamilyDao;
import Dao.FamilyDao;
import Dao.FamilyDao;
import Model.Equipment;
import Model.Family;
import Model.User;
import Model.Family;

public class FamilyAction {
	public Object[][] initializTable(String[] columnNames) throws Exception{
		FamilyDao familyDao = new FamilyDao();
		List list = familyDao.query();
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {
			Family family = (Family)list.get(i);				
			if(family.getDelete()!=0) {
				//System.out.println(type.getDelete());
			results[i][0] = family.getID();
			results[i][1] = family.getFName();
			}
		}	   	
		return results;
	}
	
	public ArrayList<String> findTableID() throws Exception{//���ؼ�ͥID
		FamilyDao familyDao = new FamilyDao();
		List list = familyDao.query();
		ArrayList<String> tar =new ArrayList<String>();
				for(int i = 0; i < list.size(); i++) {
					Family family = (Family)list.get(i);				
					if(family.getDelete()!=0) {
						//System.out.println(type.getDelete());
					tar.add(family.getID().toString());
					}
				}	
		return tar;
	}
	public void addFamily(JTextField textFname,JTextField textFid)throws Exception {
		FamilyDao familyDao=new FamilyDao();
		Family family=new Family();
		family.setID(textFid.getText());
		   if (textFname.getText() == null || textFname.getText() == "") {
	        	family.setFName(null);
	        }
	        else {
	        	family.setFName(textFname.getText());
	        }
		family.setDelete(1);
		//�������
		familyDao.addFamily(family);
	}
	//ѡ����ɾ��
	public void delFamily(JTable table) throws Exception {
		
		int selRow = table.getSelectedRow();
		String ID = table.getValueAt(selRow, 0).toString();
		
        FamilyDao familyDao=new FamilyDao();
        Family family=new Family();  
        Equipment equipment=new Equipment();
        User user =new User();
        
        family.setID(ID);
   
        // ɾ��ͼ����Ϣ 

        family.setDelete(0);
        user.setDelete(0);
        equipment.setDelete(0);
        familyDao.delFamily(family,equipment,user);
        
	}
	//ѡ�����޸�
	public void changeFamily(JTable table,JTextField textFname) throws Exception {
		if(table.getSelectedRow()<0)
		{
			JOptionPane.showMessageDialog(null,"����ѡ����Ҫ���ĵ��豸","����"
					, JOptionPane.PLAIN_MESSAGE);
		}
		int selRow = table.getSelectedRow();
		String ID = table.getValueAt(selRow, 0).toString();
		
        FamilyDao familyDao=new FamilyDao();
        Family family=new Family();     
        
        family.setID(ID);
   
        // �޸�ͼ����Ϣ
		   if (textFname.getText() == null || textFname.getText() == "") {
	        	family.setFName(null);
	        }
	        else {
	        	family.setFName(textFname.getText());
	        }
        familyDao.changeFamily(family);

	}
}
