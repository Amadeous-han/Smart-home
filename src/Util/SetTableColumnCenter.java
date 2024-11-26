package Util;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class SetTableColumnCenter {
	public SetTableColumnCenter(JTable table) {		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);   
		table.setDefaultRenderer(Object.class, r);	
	}
}
