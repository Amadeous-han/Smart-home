package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class DataNumerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataNumerFrame frame = new DataNumerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DataNumerFrame() {
		setResizable(false);
		setTitle("Data Statistics ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 523);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(">");
		comboBox.addItem("=");
		comboBox.addItem("<");
		comboBox.setBounds(126, 154, 111, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Data Name");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 97, 106, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Value");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 219, 76, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Relation");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 158, 76, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 13));
		btnNewButton.setBounds(209, 421, 97, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("0");
		textArea.setFont(new Font("MS Gothic", Font.BOLD, 48));
		textArea.setEditable(false);
		textArea.setBounds(345, 186, 122, 53);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("NUMBER");
		lblNewLabel_3.setFont(new Font("·½Õý´ÖºÚËÎ¼òÌå", Font.BOLD, 30));
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
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 281, 106, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TimeEnd");
		lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 334, 76, 15);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(126, 48, 162, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("EquipmentID");
		lblNewLabel_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 50, 106, 15);
		contentPane.add(lblNewLabel_6);
	}
}
