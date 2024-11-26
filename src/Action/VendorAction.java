package Action;

import java.util.List;

import Dao.VendorDao;
import Model.Vendor;

public class VendorAction {
	public Object[][] initializTable(String[] columnNames) throws Exception{
		VendorDao administrationDao = new VendorDao();
		List list = administrationDao.query();
		Object[][] results = new Object[list.size()+1][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {
			Vendor equipment = (Vendor)list.get(i);				

			results[i][0] = equipment.getID();
			results[i][1] = equipment.getVName();
			results[i][2] = equipment.getVCode();
		}	   	
		return results;
	}
	public int Denglu(Object[][] results,String Id,String Code) throws Exception{
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
