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
	 
	 
	    // ���ݿ���û��������룬��Ҫ�����Լ�������
	    static final String USER = "root";
	    static final String PASS = "2000108";
	    JFrame frame = new JFrame("�û�����");
	    
		JButton buttonAdd, buttonDel, buttonChange,buttonReset,buttonsearch;
		//�ı���
		JTextField textUid,textUname,textFid,textUGender;
		JPasswordField textUcode;
		// ���
		JTable table;
		// ��ʾ���Ĺ������
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
			labTitle2 = new JLabel("���� :");
			labTitle3 = new JLabel("���� :");
			labTitle4 = new JLabel("��ͥID :");
			labTitle5 = new JLabel("�Ա� :");
			
			// Id�ı���
			textUid= new JTextField("",10);	
			// �����ı���
			textUname = new JTextField("",15);
			textUcode = new JPasswordField("",8);
			textUcode.setEditable(false);
			textFid = new JTextField("",8);
			textUGender = new JTextField("",5);
	

			buttonAdd = new JButton("���");
			setButtonAdd();	
			// ɾ����ť
			buttonDel = new JButton("ɾ��");
			setButtonDel();		
			// �޸İ�ť
			buttonChange = new JButton("�޸�");
			setButtonChange();	
			// ���ð�ť
			buttonReset = new JButton("�����������");
			setButtonReset();
			buttonsearch= new JButton("�û���ģ����ѯ");
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
						JOptionPane.showMessageDialog(null,"��Ϣ�Ѿ��ɹ�����","��ʾ"
								, JOptionPane.PLAIN_MESSAGE);
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"�뽫�޸���Ϣ��д��ȫ","����"
								, JOptionPane.PLAIN_MESSAGE);
					}

				}
			});
		}
		/**
		 * �����ı������ð�ť
		 */
		//length�û�Ҫ������ַ����ĳ���
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
						JOptionPane.showMessageDialog(null,"��Ϣ�Ѿ��ɹ�ɾ��","��ʾ"
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
						JOptionPane.showMessageDialog(null,"ID�Ų���Ϊ��","����"
								, JOptionPane.PLAIN_MESSAGE);
					}

//					else if(textFname.getText().length() == 0) {
//						JOptionPane.showMessageDialog(null, "���Ʋ���Ϊ��", "����"
//								, JOptionPane.PLAIN_MESSAGE);
//					}
					else {
						try {
							userAction.addUser(textUid,textUname,textUcode,textFid,textUGender);		
							frame.setVisible(false);	
							new UserManagement();
							JOptionPane.showMessageDialog(null,"��Ϣ�Ѿ��ɹ����","��ʾ"
									, JOptionPane.PLAIN_MESSAGE);
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				
				}
			});
			}	
		private void setTable() {
			String[] columnNames = {"ID", "�û���","�û�����","��ͥID","�Ա�"};	
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
				// ���ñ���ֶξ���
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
