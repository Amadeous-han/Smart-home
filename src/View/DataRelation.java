package View;


import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Action.DataAction;
import Util.FrameOption;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class DataRelation extends JFrame {
	JFrame frame = new JFrame("DataInformation");

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
    DataAction dataAction;
    JButton btnNewButton;
    JComboBox<String> comboBox;
    JTextArea textArea;
	/**
	 * Create the frame.
	 */
	public DataRelation() {
		dataAction = new DataAction();
		setResizable(false);
		
		setTitle("Data Statistics ");
		setBounds(500, 200, 535, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(126, 94, 162, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 216, 162, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem(">");
		comboBox.addItem("=");
		comboBox.addItem("<");
		comboBox.setBounds(126, 154, 111, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Data Name");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 97, 106, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Value");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 219, 76, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Relation");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 158, 76, 15);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 13));
		btnNewButton.setBounds(209, 421, 97, 23);
		setbuttonSearch();
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setText("0");
		textArea.setFont(new Font("MS Gothic", Font.BOLD, 48));
		textArea.setEditable(false);
		textArea.setBounds(345, 186, 122, 53);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("NUMBER");
		lblNewLabel_3.setFont(new Font("方正粗黑宋简体", Font.BOLD, 30));
		lblNewLabel_3.setBounds(332, 150, 162, 27);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 278, 162, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 331, 162, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("TimeBegin");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 281, 106, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TimeEnd");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 334, 76, 15);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(126, 48, 162, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("EquipmentID");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 50, 106, 15);
		contentPane.add(lblNewLabel_6);
		
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(600, 510);
		frame.setLocation(450,200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(contentPane);
	}
	public void setbuttonSearch() {
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"测量值名称不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textField_1.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"比较值不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textField_4.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"设备Id不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textField_2.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"开始时间不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textField_3.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"截止时间不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					try {
						int a = dataAction.dataRelation(textField, textField_1, textField_4, textField_2, 
								textField_3, comboBox);
						String s = " ";
						s=String.valueOf(a);
						textArea.setText(s);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
	         }	
		});	
	}
}
