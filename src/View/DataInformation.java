package View;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Util.FrameOption;
import Util.GetData;
import Util.SetTableColumnCenter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Action.DataAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class DataInformation extends JFrame {
	JFrame frame = new JFrame("DataInformation");
	Container container = frame.getContentPane();
	
	JButton buttonAdd, buttonDel, buttonChange,buttonSearch, buttonReset;
	JButton buttonback, buttonmainnenu;
	JTextField textfieldwet,textfieldTemp,textfieldLight,textfieldEwindow;
	JTextField textfieldequipment_idE, textfieldTime;
	JLabel labTitle1,labTitle2,labTitle3,labTitle4,labTitle5,labTitle6;
	JPanel pl1,pl2,pl3,pl4,pl5,pl6;
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	
	DataAction dataAction;
	
	public DataInformation() {
		frame.setLayout(null);
		dataAction = new DataAction();
		
		pl1=new JPanel();
		pl2=new JPanel();
		pl3=new JPanel();
		pl4=new JPanel();
		pl5=new JPanel();
		pl6=new JPanel();
		
		labTitle1 = new JLabel("Wet :");
		textfieldwet = new JTextField("",14);
		pl1.add(labTitle1);
		pl1.add(textfieldwet);
		setTextFieldWet();
		
		
		labTitle2 = new JLabel("Temperqture :");
        textfieldTemp = new JTextField("",14);
        pl2.add(labTitle2);
        pl2.add(textfieldTemp);
        setTextFieldTemp();

        
        labTitle3 = new JLabel("Light :");
        textfieldLight = new JTextField("",14);
        pl3.add(labTitle3);
        pl3.add(textfieldLight);
        setTextFieldLight();
        
        
        labTitle4 = new JLabel("Window :");
        textfieldEwindow = new JTextField("",14);
        pl4.add(labTitle4);
        pl4.add(textfieldEwindow );
        setTextFieldWindow();
        
        
        labTitle5 = new JLabel("EquipmentId :");
        textfieldequipment_idE = new JTextField("",14);
        pl5.add(labTitle5);
        pl5.add(textfieldequipment_idE);
        setTextFieldEid();
        
        
        labTitle6 = new JLabel("Time :");
        textfieldTime = new JTextField("",14);
        pl6.add(labTitle6);
        pl6.add(textfieldTime);
        setTextFieldTime();
        
        setTable();
        
		// 增加按钮
		buttonAdd = new JButton("add");
		setButtonAdd();	
		// 删除按钮
		buttonDel = new JButton("delete");
		setButtonDel();		
		// 修改按钮
		buttonChange = new JButton("change");
		setButtonChange();	
		// 重置按钮
		buttonReset = new JButton("reset");
		setButtonReset();
		
		buttonSearch = new JButton("Search");
		setButtonSearch();
		
        container.add(scrollPane);
		container.add(buttonAdd);
		container.add(buttonDel);
		container.add(buttonReset);
		container.add(buttonChange);
		container.add(buttonSearch);
		container.add(pl1);
		container.add(pl2);
		container.add(pl3);
		container.add(pl4);
		container.add(pl5);
		container.add(pl6);	
		
		new GetData(frame);

	}
	
	public void setTextFieldWet() {
		pl1.setBounds(20,310,250,25);
	}
	public void setTextFieldTemp() {
		pl2.setBounds(300, 310, 250,25);
	}
    public void setTextFieldLight() {
    	pl3.setBounds(600, 310, 250,25);
	}
    public void setTextFieldWindow() {
    	pl4.setBounds(20, 370, 250,25);
    }
    public void setTextFieldTime() {
    	pl5.setBounds(300, 370,250,25);
    }
    public void setTextFieldEid() {
    	pl6.setBounds(600, 370,250,25);
    }
    
    private void setButtonChange() {
		buttonChange.setBounds(395,420,100,25);
		buttonChange.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {	
				try {
					dataAction.changeDataInfo(textfieldwet, textfieldTemp
							,textfieldLight, textfieldEwindow, textfieldequipment_idE, textfieldTime, table);		
					frame.setVisible(false);
					new DataInformation();				
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"表中没有该数据","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
	private void setButtonDel() {
		buttonDel.setBounds(520,420,100,25);
		buttonDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dataAction.delData(table);
					frame.setVisible(false);	
					new DataInformation();
				} catch(Exception e1) {
					e1.printStackTrace();
				}			
			}
		});
	}
	/**
	 * 设置添加按钮
	 */
	private void setButtonAdd() {
		buttonAdd.setBounds(640,420,100,25);
		buttonAdd.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textfieldwet.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"湿度不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}	
				else if(textfieldTemp.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "温度不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textfieldLight.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "光照强度不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textfieldEwindow.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "门窗状态不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textfieldequipment_idE.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "设备id不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					try {
						dataAction.addDataInfo(textfieldwet,  textfieldTemp,
		                         textfieldLight,  textfieldEwindow,  textfieldequipment_idE);		
						frame.setVisible(false);	
						new DataInformation();
					}catch(Exception e1) {
//						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "不能添加不存在的设备id！", "错误"
								, JOptionPane.PLAIN_MESSAGE);
						//System.out.println("不能添加不存在的设备id！");
					}
				}		
			}
		});
	}
	
	private void setButtonReset() {
		buttonReset.setBounds(270,420,100,25);
		buttonReset.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfieldwet.setText("");
				textfieldTemp.setText("");
				textfieldLight.setText("");
				textfieldEwindow.setText("");
				textfieldequipment_idE.setText("");
				textfieldTime.setText("");		
			}
		});
	}
	
	public void setButtonSearch() {
		buttonSearch.setBounds(150, 420, 100, 25);
		buttonSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DataSearch();
			}
			
		});
	}
	
	private void setTable() {
		String[] columnNames = {"iddata", "wet(%)", "temperature(℃)", "light(Lux)", 
				"Ewindow", "equipment_idE", "time"};	
		try {
			DataAction dataAction = new DataAction();
			Object[][] results = dataAction.initializTable(columnNames);
		
			table = new JTable(results,columnNames);
			// 设置表格字段居中
			new SetTableColumnCenter(table);
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportView(table);
			scrollPane.setBounds(20,80,850,190);			
			table.addMouseListener(new MouseListener() {			
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub			
				}			
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub	
				}				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub					
				}				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub					
				}			
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					String wet, temp, light;
					String Ewindow, equipment_idE, time ;
					
					int selRow = table.getSelectedRow();
					wet = table.getValueAt(selRow, 1).toString();
					temp = table.getValueAt(selRow, 2).toString();
					light = table.getValueAt(selRow, 3).toString();
					Ewindow = table.getValueAt(selRow, 4).toString();
					equipment_idE = table.getValueAt(selRow, 5).toString();
					time = table.getValueAt(selRow, 6).toString();	
					textfieldwet.setText(wet);
					textfieldLight.setText(light);
					textfieldTemp.setText(temp);
					textfieldEwindow.setText(Ewindow);
					textfieldequipment_idE.setText(equipment_idE);
					textfieldTime.setText(time);
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		 new DataInformation();
	}
}

