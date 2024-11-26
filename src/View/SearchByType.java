package View;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Action.DataAction;
import Util.GetData;
import Util.SetTableColumnCenter;

public class SearchByType {
	JFrame frame = new JFrame("DataInformation");
	Container container = frame.getContentPane();
	
    JButton buttonSearch;
    JTextField textfieldType, startTime, finishTime;
    JLabel label1,label2,label3;
    
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	
	DataAction dataAction;
	public SearchByType() {
		frame.setLayout(null);
		dataAction = new DataAction();
		
		label1 = new JLabel("TypeId: ");
		label1.setBounds(50, 50, 80, 25);
		label2 = new JLabel("From: ");
		label2.setBounds(330, 50, 50, 25);
		label3 = new JLabel("To: ");
		label3.setBounds(630, 50, 50, 25);
		
		buttonSearch = new JButton("Search!");
		setButtonSearch();
		textfieldType = new JTextField();
		setTextFieldEid();
		startTime = new JTextField();
		setStartTime();
		finishTime= new JTextField();
		setFinishTime();
		
		container.add(label1);
		container.add(label2);
	    container.add(label3);
		container.add(textfieldType);		
		container.add(startTime);	
		container.add(finishTime);
		container.add(buttonSearch);
		
		new GetData(frame);
	}
	public void setButtonSearch() {
		buttonSearch.setBounds(390, 120, 100, 25);
		
		buttonSearch.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textfieldType.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"设备类型编号不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(startTime.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"起始时间不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(finishTime.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"截至时间不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else
					setTable(textfieldType, startTime, finishTime);
			}
	});
	}
	public void setTextFieldEid() {
		textfieldType.setBounds(100, 50, 150, 25);
	}
	public void setStartTime() {
		startTime.setBounds(380, 50, 150, 25);
	}
	public void setFinishTime() {
		finishTime.setBounds(660, 50, 150, 25);
	}
	public void setTable(JTextField textfieldType, JTextField stratTime, JTextField finishTime) {
		String[] columnNames = {"iddata", "wet(%)", "temperature(℃)", "light(Lux)", 
				"Ewindow", "equipment_idE", "time"};	
		try {
			DataAction dataAction = new DataAction();
			Object[][] results = dataAction.getTableByType(columnNames,textfieldType, stratTime, finishTime );
			
				table = new JTable(results,columnNames);
				// 设置表格字段居中
				new SetTableColumnCenter(table);
				scrollPane = new JScrollPane(table);
				scrollPane.setViewportView(table);
				scrollPane.setBounds(20,180,850,220);			
				 container.add(scrollPane);
		} catch(Exception e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"无对应数据！","报告"
					, JOptionPane.PLAIN_MESSAGE);
		}
	}
}