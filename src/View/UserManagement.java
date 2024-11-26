package View;

import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Action.UserAction;
import Util.FrameOption;
import Util.MenuBar;
import Util.SetTableColumnCenter;

public class UserManagement {
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	 
	 
	    // 数据库的用户名与密码，需要根据自己的设置
	    static final String USER = "root";
	    static final String PASS = "2000108";
	    JFrame frame = new JFrame("用户管理");
	    
		JButton buttonAdd, buttonDel, buttonChange,buttonReset,buttonsearch;
		//文本框
		JTextField textUid,textUname,textFid,textUGender;
		JPasswordField textUcode;
		// 表格
		JTable table;
		// 显示表格的滚动面板
		JScrollPane scrollPane;
		JPanel pl1,pl2,pl3,pl4,pl5,pl6;
		JLabel labTitle1,labTitle2,labTitle3,labTitle4,labTitle5;
		UserAction userAction;
		TableRowSorter<TableModel> sorter ;
		public UserManagement() {
			frame.setLayout(null);
			Container container = frame.getContentPane();
			new MenuBar(frame);
			userAction = new UserAction();
			pl1=new JPanel();
			pl2=new JPanel();
			pl3=new JPanel();
			pl4=new JPanel();
			pl5=new JPanel();
			pl6=new JPanel();

			labTitle1 = new JLabel("I D :");
			labTitle2 = new JLabel("名称 :");
			labTitle3 = new JLabel("密码 :");
			labTitle4 = new JLabel("家庭ID :");
			labTitle5 = new JLabel("性别 :");
			
			// Id文本框
			textUid= new JTextField("",10);	
			// 名称文本框
			textUname = new JTextField("",15);
			textUcode = new JPasswordField("",8);
			textUcode.setEditable(false);
			textFid = new JTextField("",8);
			textUGender = new JTextField("",5);
	

			buttonAdd = new JButton("添加");
			setButtonAdd();	
			// 删除按钮
			buttonDel = new JButton("删除");
			setButtonDel();		
			// 修改按钮
			buttonChange = new JButton("修改");
			setButtonChange();	
			// 重置按钮
			buttonReset = new JButton("随机生成密码");
			setButtonReset();
			buttonsearch= new JButton("用户名模糊查询");
			setButtonsearch();
			setTable();
		    pl1.add(labTitle1);
			pl1.add(textUid);
			
			pl2.add(labTitle2);
			pl2.add(textUname);
			
			pl3.add(labTitle3);
			pl3.add(textUcode);
			
			pl4.add(labTitle4);
			pl4.add(textFid);
			
			pl5.add(labTitle5);
			pl5.add(textUGender);
			
			container.add(scrollPane);
			container.add(buttonAdd);
			container.add(buttonDel);
			container.add(buttonReset);
			container.add(buttonChange);
			container.add(buttonsearch);
			container.add(pl1);
			container.add(pl2);
			container.add(pl3);
			container.add(pl4);
			container.add(pl5);
			pl1.setBounds(50,280,140,23);//id
			pl2.setBounds(200,280,240,123);//mingzi
			pl3.setBounds(35,340,140,23);//mima
			pl4.setBounds(450,280,140,23);
			pl5.setBounds(440,340,140,23);
			new FrameOption(frame);
		}
		private void setButtonsearch() {
			buttonsearch.setBounds(50,390,150,25);
		}
		private void setButtonChange() {
			buttonChange.setBounds(470,390,60,25);
			buttonChange.addActionListener(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {	
					try {
						userAction.changeUser(table,textUname,textUcode,textFid,textUGender);		
						frame.setVisible(false);
						new UserManagement();	
						JOptionPane.showMessageDialog(null,"信息已经成功更改","提示"
								, JOptionPane.PLAIN_MESSAGE);
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"请将修改信息填写齐全","错误"
								, JOptionPane.PLAIN_MESSAGE);
					}

				}
			});
		}
		/**
		 * 设置文本框重置按钮
		 */
		//length用户要求产生字符串的长度
		 public static String getRandomString(int length){
		     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		     Random random=new Random();
		     StringBuffer sb=new StringBuffer();
		     for(int i=0;i<length;i++){
		       int number=random.nextInt(62);
		       sb.append(str.charAt(number));
		     }
		     return sb.toString();
		 }
		private void setButtonReset() {
			buttonReset.setBounds(270,390,150,25);
			buttonReset.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String randomcode=getRandomString(6);
					textUcode.setText(randomcode);
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
						userAction.delUser(table);
						frame.setVisible(false);	
						new UserManagement();
						JOptionPane.showMessageDialog(null,"信息已经成功删除","提示"
								, JOptionPane.PLAIN_MESSAGE);
					} catch(Exception e1) {
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

//					else if(textFname.getText().length() == 0) {
//						JOptionPane.showMessageDialog(null, "名称不能为空", "错误"
//								, JOptionPane.PLAIN_MESSAGE);
//					}
					else {
						try {
							userAction.addUser(textUid,textUname,textUcode,textFid,textUGender);		
							frame.setVisible(false);	
							new UserManagement();
							JOptionPane.showMessageDialog(null,"信息已经成功添加","提示"
									, JOptionPane.PLAIN_MESSAGE);
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				
				}
			});
			}	
		private void setTable() {
			String[] columnNames = {"ID", "用户名","用户密码","家庭ID","性别"};	
			try {
				UserAction userAction = new UserAction();
				Object[][] results = userAction.initializTable(columnNames);
				table = new JTable(results,columnNames);
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
				// 设置表格字段居中
				new SetTableColumnCenter(table);
				scrollPane = new JScrollPane(table);
				scrollPane.setViewportView(table);
				scrollPane.setBounds(20,80,760,190);
				buttonsearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String text = textUname.getText();
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
						String UID,  UName,Ucode,Fid,Gender;
						int selRow = table.getSelectedRow();
				
						UID = table.getValueAt(selRow, 0).toString();
						UName = table.getValueAt(selRow, 1).toString();
						Ucode = table.getValueAt(selRow, 2).toString();	
						Fid = table.getValueAt(selRow, 3).toString();
						Gender = table.getValueAt(selRow, 4).toString();
						textUname.setText(UName);
						textFid.setText(Fid);
						textUid.setText(UID);
						textUGender.setText(Gender);
						textUcode.setText(Ucode);
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
			new UserManagement();
		}
		
}
