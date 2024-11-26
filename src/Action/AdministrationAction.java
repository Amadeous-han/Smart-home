package Action;

import java.util.List;

import Dao.AdministrationDao;
import Model.Administration;

public class AdministrationAction {
	public Object[][] initializTable(String[] columnNames) throws Exception{
		AdministrationDao administrationDao = new AdministrationDao();
		List list = administrationDao.query();
		Object[][] results = new Object[list.size()+1][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {
			Administration equipment = (Administration)list.get(i);				

			results[i][0] = equipment.getID();
			results[i][1] = equipment.getAName();
			results[i][2] = equipment.getACode();
		}	   	
		return results;
	}
	public int Denglu(Object[][] results,String Id,String Code) throws Exception{
		String[] tar = {"未能查询到管理者ID","密码输入错误","","","","","",""};
		int success=-1;
		for(int i=0;results[i][0]!=null;i++)
		{
			if( ((String) results[i][0]).compareTo(Id)==0)
			{
				    success=0;
				if(((String) results[i][2]).compareTo(Code)==0)
					success=1;
			}
				
		}
		return success;
	}
}
