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
import javax.swing.WindowConstants;

import Action.DataAction;
import Util.GetData;
import Util.SetTableColumnCenter;

public class SearchByFamily {
	
	JFrame frame = new JFrame("DataInformation");
	Container container = frame.getContentPane();
	
    JButton buttonSearch;
    JTextField textfieldFid, startTime, finishTime;
    JLabel label1,label2,label3;
    
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	
	DataAction dataAction;
	public SearchByFamily() {
		frame.setLayout(null);
		dataAction = new DataAction();
		
		label1 = new JLabel("FamilyId: ");
		label1.setBounds(90, 50, 80, 25);
		label2 = new JLabel("From: ");
		label2.setBounds(380, 50, 80, 25);
		label3 = new JLabel("To: ");
		label3.setBounds(680, 50, 50, 25);
		buttonSearch = new JButton("Search!");
		setButtonSearch();
		textfieldFid = new JTextField();
		setTextFieldfid();
		startTime = new JTextField();
		setStartTime();
		finishTime= new JTextField();
		setFinishTime();
		
	    container.add(label1);
	    container.add(label2);
	    container.add(label3);
		container.add(textfieldFid);		
		container.add(startTime);	
		container.add(finishTime);
		container.add(buttonSearch);
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(1000, 510);
		frame.setLocation(250,200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setButtonSearch() {
		buttonSearch.setBounds(420, 120, 100, 30);
		
		buttonSearch.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textfieldFid.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"家庭编号不能为空","错误"
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
				setTable(textfieldFid, startTime, finishTime);
			}
	});
	}
	public void setTextFieldfid() {
		textfieldFid.setBounds(150, 50, 150, 25);
	}
	public void setStartTime() {
		startTime.setBounds(430, 50, 150, 25);
	}
	public void setFinishTime() {
		finishTime.setBounds(710, 50, 150, 25);
	}
	public void setTable(JTextField fid, JTextField stratTime, JTextField finishTime) {
		String[] columnNames = {"FamilyId","iddata", "wet(%)", "temperature(℃)", "light(Lux)", 
				"Ewindow", "equipment_idE", "equipmentName","time"};	
		try {
			DataAction dataAction = new DataAction();
			Object[][] results = dataAction.getTableByFamily(columnNames,fid, stratTime, finishTime );
			table = new JTable(results,columnNames);
			// 设置表格字段居中
			new SetTableColumnCenter(table);
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportView(table);
			scrollPane.setBounds(10,180,960,220);			
			 container.add(scrollPane);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SearchByFamily();
	}
}

