package Action;

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

public class SearchByEid {
	
	JFrame frame = new JFrame("DataInformation");
	Container container = frame.getContentPane();
	
    JButton buttonSearch;
    JTextField textfieldEid, startTime, finishTime;
    JLabel label1,label2,label3;
    
	JTable table;
	// ��ʾ���Ĺ������
	JScrollPane scrollPane;
	
	DataAction dataAction;
	public SearchByEid() {
		frame.setLayout(null);
		dataAction = new DataAction();
		
		label1 = new JLabel("EquipmentId: ");
		label1.setBounds(20, 50, 80, 25);
		label2 = new JLabel("From: ");
		label2.setBounds(330, 50, 80, 25);
		label3 = new JLabel("To: ");
		label3.setBounds(630, 50, 50, 25);
		buttonSearch = new JButton("Search!");
		setButtonSearch();
		textfieldEid = new JTextField();
		setTextFieldEid();
		startTime = new JTextField();
		setStartTime();
		finishTime= new JTextField();
		setFinishTime();
		
	    container.add(label1);
	    container.add(label2);
	    container.add(label3);
		container.add(textfieldEid);		
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
				if(textfieldEid.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"�豸��Ų���Ϊ��","����"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(startTime.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"��ʼʱ�䲻��Ϊ��","����"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(finishTime.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"����ʱ�䲻��Ϊ��","����"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else
				setTable(textfieldEid, startTime, finishTime);
			}
	});
	}
	public void setTextFieldEid() {
		textfieldEid.setBounds(100, 50, 150, 25);
	}
	public void setStartTime() {
		startTime.setBounds(380, 50, 150, 25);
	}
	public void setFinishTime() {
		finishTime.setBounds(660, 50, 150, 25);
	}
	public void setTable(JTextField textfieldEid, JTextField stratTime, JTextField finishTime) {
		String[] columnNames = {"iddata", "wet(%)", "temperature(��)", "light(Lux)", 
				"Ewindow", "equipment_idE", "time"};	
		try {
			DataAction dataAction = new DataAction();
			Object[][] results = dataAction.getTable(columnNames,textfieldEid, stratTime, finishTime );
			table = new JTable(results,columnNames);
			// ���ñ���ֶξ���
			new SetTableColumnCenter(table);
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportView(table);
			scrollPane.setBounds(20,180,850,220);			
			 container.add(scrollPane);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"�޶�Ӧ���ݣ�","����"
					, JOptionPane.PLAIN_MESSAGE);
		}
	}
}
