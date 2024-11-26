package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Action.*;
import Util.*;
import Util.MenuBar;
public class TypeManagement  extends JFrame implements ActionListener {
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
//    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
// 
// 
//    // ���ݿ���û��������룬��Ҫ�����Լ�������
//    static final String USER = "root";
//    static final String PASS = "2000108";
    JFrame frame = new JFrame("���͹���");
	// ���ӡ�ɾ�����޸İ�ť
	JButton buttonAdd, buttonDel, buttonChange,buttonReset;
	//�ı���
	JTextField textTname,textTid;
	// ���
	JTable table;
	// ��ʾ���Ĺ������
	JScrollPane scrollPane;
	JPanel pl1,pl2;
	JLabel labTitle1,labTitle2;
	TypeAction typeAction;
	TableRowSorter<TableModel> sorter ;
	public TypeManagement() {
		frame.setLayout(null);
		Container container = frame.getContentPane();
		new MenuBar(frame);
		typeAction = new TypeAction();
		 pl1=new JPanel();
		 pl2=new JPanel();
		 labTitle1 = new JLabel("I D :");
		 labTitle2 = new JLabel("����:");
		// Id�ı���
		textTid= new JTextField("",10);
		setTextFieldISBN();		
		// �����ı���
		textTname = new JTextField("",10);
		setTextFieldName();
		// ���Ӱ�ť
		buttonAdd = new JButton("���");
		setButtonAdd();	
		// ɾ����ť
		buttonDel = new JButton("ɾ��");
		setButtonDel();		
		// �޸İ�ť
		buttonChange = new JButton("�޸�");
		setButtonChange();	
		// ���ð�ť
		buttonReset = new JButton("��������ģ����ѯ");
		setButtonReset();
		// ���ô�����
		setTable();
	     pl1.add(labTitle1);
		 pl1.add(textTid);
		 pl2.add(labTitle2);
		 pl2.add(textTname);
		container.add(scrollPane);
		container.add(buttonAdd);
		container.add(buttonDel);
		container.add(buttonReset);
		container.add(buttonChange);
		container.add(pl1);
		container.add(pl2);
		
		new FrameOption(frame);
		
	}
	private void setTextFieldISBN() {
		pl1.setBounds(120,280,140,23);
		//textTid.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"ID"));	
	}
	private void setTextFieldName() {
		pl2.setBounds(348,280,240,123);
		//textTname.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"����"));	
	}
	private void setButtonChange() {
		buttonChange.setBounds(470,390,60,25);
		buttonChange.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {	
				try {
					typeAction.changeType(table,textTname);		
					frame.setVisible(false);
					new TypeManagement();	
					JOptionPane.showMessageDialog(null,"��Ϣ�Ѿ��ɹ�����","��ʾ"
							, JOptionPane.PLAIN_MESSAGE);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"����","����"
							, JOptionPane.PLAIN_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
	}
	/**
	 * �����ı������ð�ť
	 */
	private void setButtonReset() {
		buttonReset.setBounds(270,390,150,25);
		}
	
	private void setButtonDel() {
		buttonDel.setBounds(580,390,60,25);
		buttonDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					typeAction.delType(table);
					frame.setVisible(false);	
					JOptionPane.showMessageDialog(null,"��Ϣ�Ѿ��ɹ�ɾ��","��ʾ"
							, JOptionPane.PLAIN_MESSAGE);
					new TypeManagement();
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"����������","��ʾ"
							, JOptionPane.PLAIN_MESSAGE);
					new TypeManagement();
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
				if(textTid.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"ID�Ų���Ϊ��","����"
							, JOptionPane.PLAIN_MESSAGE);
				}

				else if(textTname.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "���Ʋ���Ϊ��", "����"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					try {
						typeAction.addType(textTname,textTid);		
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null,"��Ϣ�Ѿ��ɹ����","��ʾ"
								, JOptionPane.PLAIN_MESSAGE);
						new TypeManagement();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			
			}
		});
		}

	
	
	
	
	
	
	
	
	
	
	
	private void setTable() {
		String[] columnNames = {"ID", "�������"};	
		try {
			TypeAction typeAction = new TypeAction();
			Object[][] results = typeAction.initializTable(columnNames);
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
			buttonReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = textTname.getText();
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
					String TypeID,  TypeName;
					int selRow = table.getSelectedRow();
			
					TypeID = table.getValueAt(selRow, 0).toString();
					TypeName = table.getValueAt(selRow, 1).toString();
								
					textTname.setText(TypeID);
					textTid.setText(TypeName);
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
