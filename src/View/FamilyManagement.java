package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Action.FamilyAction;
import Action.TypeAction;
import Util.FrameOption;
import Util.MenuBar;
import Util.SetTableColumnCenter;

public class FamilyManagement extends JFrame implements ActionListener{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "2000108";
    JFrame frame = new JFrame("��ͥ����");
	// ���ӡ�ɾ�����޸İ�ť
	JButton buttonAdd, buttonDel, buttonChange,buttonReset;
	TableRowSorter<TableModel> sorter ;
	//�ı���
	JTextField textFname,textFid;
	// ���
	JTable table;
	// ��ʾ���Ĺ������
	JScrollPane scrollPane;
	JPanel pl1,pl2;
	JLabel labTitle1,labTitle2;
	FamilyAction familyAction;

	public FamilyManagement() {
		frame.setLayout(null);
		Container container = frame.getContentPane();
		new MenuBar(frame);
		familyAction = new FamilyAction();
		 pl1=new JPanel();
		 pl2=new JPanel();
		 labTitle1 = new JLabel("I D :");
		 labTitle2 = new JLabel("����:");
		// Id�ı���
		textFid= new JTextField("",10);
		setTextFieldISBN();		
		// �����ı���
		textFname = new JTextField("",10);
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
		buttonReset = new JButton("ID��ѯ");
		setButtonReset();
		// ���ô�����
		setTable();
	     pl1.add(labTitle1);
		 pl1.add(textFid);
		 pl2.add(labTitle2);
		 pl2.add(textFname);
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
					familyAction.changeFamily(table,textFname);		
					frame.setVisible(false);
					new FamilyManagement();	
					JOptionPane.showMessageDialog(null,"��Ϣ�Ѿ��ɹ�����","��ʾ"
							, JOptionPane.PLAIN_MESSAGE);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"����û�и�����","����"
							, JOptionPane.PLAIN_MESSAGE);
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
					familyAction.delFamily(table);
					frame.setVisible(false);	
					new FamilyManagement();
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

//				else if(textFname.getText().length() == 0) {
//					JOptionPane.showMessageDialog(null, "���Ʋ���Ϊ��", "����"
//							, JOptionPane.PLAIN_MESSAGE);
//				}
				else {
					try {
						familyAction.addFamily(textFname,textFid);		
						frame.setVisible(false);	
						new FamilyManagement();
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
		String[] columnNames = {"ID", "��ͥ����"};	
		try {
			FamilyAction familyAction = new FamilyAction();
			Object[][] results = familyAction.initializTable(columnNames);
			table = new JTable(results,columnNames);
			TableModel model = new DefaultTableModel(results, columnNames) {
				public Class getColumnClass(int column) {
					Class returnValue = null;
					if ((column >= 0) && (column < getColumnCount())) {
						int i=0;
						while(getValueAt(i, column)==null)
						{
						i++;
						}
						returnValue = getValueAt(i, column).getClass();
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
					String text = textFid.getText();
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
					String FamilyID,  FamilyName;
					int selRow = table.getSelectedRow();
			
					FamilyID = table.getValueAt(selRow, 0).toString();
					textFid.setText(FamilyID);
					if(table.getValueAt(selRow, 1)!=null)
					{
					FamilyName = table.getValueAt(selRow, 1).toString();
					textFname.setText(FamilyName);
					}		
					
					
					
			
						
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
