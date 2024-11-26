package View;
import java.awt.Container;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Action.EquipmentAction;
import Action.UserAction;
import Util.FrameOption;
import Util.MenuBar;
import Util.SetTableColumnCenter;

public class EquipmentManagement{
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	 
	 
	    // 数据库的用户名与密码，需要根据自己的设置
	    static final String USER = "root";
	    static final String PASS = "2000108";
	JFrame frame = new JFrame("设备管理");
	TableRowSorter<TableModel> sorter ;
	Container container = frame.getContentPane();
	JButton buttonAdd, buttonDel, buttonChange,buttonReset;
	JTextField textId, textEName, textFid, textEfunc,textVID,textTID;
	
	// 表格
			JTable table;
			JScrollPane pane;
			// 显示表格的滚动面板
			JScrollPane scrollPane;
			JPanel pl1,pl2,pl3,pl4,pl5,pl6;
			JLabel labTitle1,labTitle2,labTitle3,labTitle4,labTitle5,labTitle6;
			EquipmentAction equipmentAction;
			
			public EquipmentManagement() {
				frame.setLayout(null);
				Container container = frame.getContentPane();
				new MenuBar(frame);
				equipmentAction = new EquipmentAction();
				pl1=new JPanel();
				pl2=new JPanel();
				pl3=new JPanel();
				pl4=new JPanel();
				pl5=new JPanel();
				pl6=new JPanel();

				labTitle1 = new JLabel("I D :");
				labTitle2 = new JLabel("名称 :");
				labTitle3 = new JLabel("功能 :");
				labTitle4 = new JLabel("家庭ID :");
				labTitle5 = new JLabel("类型ID :");
				labTitle6 = new JLabel("厂家ID :");
				
				textId= new JTextField("",8);
				textEName = new JTextField("",8);
				textEfunc = new JTextField("",15);
				textFid = new JTextField("",8);
				textTID = new JTextField("",8);
				textVID = new JTextField("",8);
				
				buttonAdd = new JButton("添加");
				setButtonAdd();	
				// 删除按钮
				buttonDel = new JButton("删除");
				setButtonDel();		
				// 修改按钮
				buttonChange = new JButton("修改");
				setButtonChange();	
				// 重置按钮
				buttonReset = new JButton("名称模糊查询");
				setButtonSearch(textId.getText().toString());
				setTable();
				
			    pl1.add(labTitle1);
				pl1.add(textId);
				
				pl2.add(labTitle2);
				pl2.add(textEName);
				
				pl3.add(labTitle3);
				pl3.add(textEfunc);
				
				pl4.add(labTitle4);
				pl4.add(textFid);
				
				pl5.add(labTitle5);
				pl5.add(textTID);
				
				pl6.add(labTitle6);
				pl6.add(textVID);
				
				container.add(scrollPane);
				container.add(buttonAdd);
				container.add(buttonDel);
				container.add(buttonChange);
				container.add(buttonReset);
				container.add(pl1);
				container.add(pl2);
				container.add(pl3);
				container.add(pl4);
				container.add(pl5);
				container.add(pl6);
				pl1.setBounds(50,280,140,23);//id
				pl2.setBounds(210,280,140,23);//mingzi
				pl4.setBounds(35,340,140,23);//mima
				pl3.setBounds(350,280,250,23);
				pl5.setBounds(370,340,140,23);
				pl6.setBounds(200,340,140,23);
				new FrameOption(frame);
				
				
			}
			private void setButtonSearch(String ID)
			{
				buttonReset.setBounds(270,390,150,25);
//				buttonReset.addActionListener(new ActionListener() {			
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// TODO Auto-generated method stub
//						if (ID.length() == 0) {
//							sorter.setRowFilter(null);
//						} else {
//							sorter.setRowFilter(RowFilter.regexFilter(ID));
//							System.out.println("1");
//						}
//
//					}
//
//				});
				
			}
			private void setButtonChange() {
				buttonChange.setBounds(470,390,60,25);
				buttonChange.addActionListener(new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent e) {	
						try {
							equipmentAction.changeEquipment(table, textEName, textEfunc, textFid, textTID, textVID);		
							frame.setVisible(false);
							new EquipmentManagement();	
							JOptionPane.showMessageDialog(null,"信息已经成功更改","提示"
									, JOptionPane.PLAIN_MESSAGE);
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(null,"请将信息完善","错误"
									, JOptionPane.PLAIN_MESSAGE);
							e1.printStackTrace();
						}

					}
				});
			}
			private void setButtonDel() {
				
				buttonDel.setBounds(580,390,60,25);
				buttonDel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							equipmentAction.delEquipment(table);
							frame.setVisible(false);	
							new EquipmentManagement();
							JOptionPane.showMessageDialog(null,"信息已经成功删除","提示", JOptionPane.PLAIN_MESSAGE);
						} catch(Exception e1) {
							JOptionPane.showMessageDialog(null,"信息未能成功删除，请重试","提示", JOptionPane.PLAIN_MESSAGE);
							new EquipmentManagement();
							e1.printStackTrace();
						}			
					}
				});
			}
			private void setButtonAdd() {
				buttonAdd.setBounds(700,390,60,25);
				buttonAdd.addActionListener(new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(textFid.getText().length() == 0) {
							JOptionPane.showMessageDialog(null,"ID号不能为空","错误"
									, JOptionPane.PLAIN_MESSAGE);
						}

//						else if(textFname.getText().length() == 0) {
//							JOptionPane.showMessageDialog(null, "名称不能为空", "错误"
//									, JOptionPane.PLAIN_MESSAGE);
//						}
						else {
							try {
								((EquipmentAction) equipmentAction).addEquipment(textId, textEName, textEfunc, textFid, textTID, textVID);		
								frame.setVisible(false);	
								new EquipmentManagement();
								JOptionPane.showMessageDialog(null,"信息已经成功添加","提示"
										, JOptionPane.PLAIN_MESSAGE);
							}catch(Exception e1) {
								JOptionPane.showMessageDialog(null,"信息未能成功添加，请核对ID、家庭ID和厂家ID后，重新尝试","提示"
										, JOptionPane.PLAIN_MESSAGE);
								new EquipmentManagement();
								e1.printStackTrace();
							}
						}
					
					}
				});
				}	
			private void setTable() {
				String[] columnNames = {"ID", "设备名","设备功能","家庭ID","类型ID","厂家ID"};	
				try {
					EquipmentAction equipmentAction = new EquipmentAction();
					Object[][] results = equipmentAction.initializTable(columnNames);
					
					TableModel model = new DefaultTableModel(results, columnNames) {
						public Class getColumnClass(int column) {
							Class returnValue;
							if ((column >= 0) && (column < getColumnCount())) {
								returnValue = getValueAt(0, column).getClass();
							} else {
								returnValue = Object.class;
							}
							return returnValue;
						}
					};
					table = new JTable(model);
					sorter = new TableRowSorter<TableModel>(
							model);
					table.setRowSorter(sorter);
					//pane = new JScrollPane(table);
					// 设置表格字段居中
					new SetTableColumnCenter(table);
					scrollPane = new JScrollPane(table);
					scrollPane.setViewportView(table);
					scrollPane.setBounds(20,80,760,190);
					buttonReset.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String text = textEName.getText();
							if (text.length() == 0) {
								sorter.setRowFilter(null);
							} else {
								sorter.setRowFilter(RowFilter.regexFilter(text));
							}
						}
					});
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
							String EID,  EName,Efunc,Fid,TID,VID;
							int selRow = table.getSelectedRow();
					
							EID = table.getValueAt(selRow, 0).toString();
							EName = table.getValueAt(selRow, 1).toString();
							Efunc = table.getValueAt(selRow, 2).toString();	
							Fid = table.getValueAt(selRow, 3).toString();
							TID = table.getValueAt(selRow, 4).toString();
							VID = table.getValueAt(selRow, 5).toString();
							textEName.setText(EName);
							textFid.setText(Fid);
							textId.setText(EID);
							textEfunc.setText(Efunc);
							textTID.setText(TID);
							textVID.setText(VID);
						}
					});
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			public static void main(String[] args) {
			 new EquipmentManagement();
			}
}
