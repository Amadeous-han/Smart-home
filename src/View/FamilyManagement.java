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
 
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "2000108";
    JFrame frame = new JFrame("家庭管理");
	// 增加、删除、修改按钮
	JButton buttonAdd, buttonDel, buttonChange,buttonReset;
	TableRowSorter<TableModel> sorter ;
	//文本框
	JTextField textFname,textFid;
	// 表格
	JTable table;
	// 显示表格的滚动面板
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
		 labTitle2 = new JLabel("名称:");
		// Id文本框
		textFid= new JTextField("",10);
		setTextFieldISBN();		
		// 名称文本框
		textFname = new JTextField("",10);
		setTextFieldName();
		// 增加按钮
		buttonAdd = new JButton("添加");
		setButtonAdd();	
		// 删除按钮
		buttonDel = new JButton("删除");
		setButtonDel();		
		// 修改按钮
		buttonChange = new JButton("修改");
		setButtonChange();	
		// 重置按钮
		buttonReset = new JButton("ID查询");
		setButtonReset();
		// 设置窗体表格
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
		//textTname.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"名称"));	
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
					JOptionPane.showMessageDialog(null,"信息已经成功更改","提示"
							, JOptionPane.PLAIN_MESSAGE);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"表中没有该数据","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
	}
	/**
	 * 设置文本框重置按钮
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

//				else if(textFname.getText().length() == 0) {
//					JOptionPane.showMessageDialog(null, "名称不能为空", "错误"
//							, JOptionPane.PLAIN_MESSAGE);
//				}
				else {
					try {
						familyAction.addFamily(textFname,textFid);		
						frame.setVisible(false);	
						new FamilyManagement();
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
		String[] columnNames = {"ID", "家庭名称"};	
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
			// 设置表格字段居中
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
