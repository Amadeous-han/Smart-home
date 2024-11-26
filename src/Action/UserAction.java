package Action;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Dao.UserDao;
import Model.User;


public class UserAction {
	public Object[][] initializTable(String[] columnNames) throws Exception{
		UserDao userDao = new UserDao();
		List list = userDao.query();
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {
			User user = (User)list.get(i);				
			if(user.getDelete()!=0) {
				//System.out.println(type.getDelete());
			results[i][0] = user.getID();
			results[i][1] = user.getUName();
			results[i][2] = user.getUCode();
			results[i][3] = user.getFID();
			results[i][4] = user.getGender();
			//results[i][5] = user.getDelete();
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
				tar[2]=(String) results[i][2];
				tar[3]=(String) results[i][3];
				tar[4]=(String) results[i][4];
				tar[5]=(String) results[i][5];
			}
		}
		return tar;
	}
	public void addUser(JTextField textUid,JTextField textUname,JTextField textUcode,JTextField textFid,JTextField textUGender)throws Exception {
		UserDao userDao=new UserDao();
		User user=new User();
		user.setID(textUid.getText());
		user.setUName(textUname.getText());
		user.setUCode(textUcode.getText());
		user.setFID(textFid.getText());
		user.setGender(textUGender.getText());
		user.setDelete(1);
		//添加类型
		userDao.addUser(user);
	}
	public void delUser(JTable table) throws Exception {
		
		int selRow = table.getSelectedRow();
		String ID = table.getValueAt(selRow, 0).toString();
		
        UserDao userDao=new UserDao();
        User user=new User();     
        
        user.setID(ID);
   


        user.setDelete(0);
        userDao.delUser(user);
        
	}
	//选中行修改
		public void changeUser(JTable table,JTextField textUname,JTextField textUcode,JTextField textFid,JTextField textUGender) throws Exception {
			if(table.getSelectedRow()<0)
			{
				JOptionPane.showMessageDialog(null,"请先选中想要更改的设备","错误"
						, JOptionPane.PLAIN_MESSAGE);
			}
			int selRow = table.getSelectedRow();
			String ID = table.getValueAt(selRow, 0).toString();
			
	        UserDao userDao=new UserDao();
	        User user=new User();     
	        
	        user.setID(ID);
			user.setUName(textUname.getText());
			user.setUCode(textUcode.getText());
			user.setFID(textFid.getText());
			user.setGender(textUGender.getText());
	       userDao.changeUser(user);
		}
}

