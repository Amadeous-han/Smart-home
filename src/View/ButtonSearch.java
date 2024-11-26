package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ButtonSearch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonSearch frame = new ButtonSearch();
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
	public ButtonSearch() {
		setTitle("Query And Pivot ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(0, 204, 204));
		btnNewButton.setForeground(new Color(0, 102, 102));
		btnNewButton.setBounds(29, 186, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setForeground(new Color(0, 102, 102));
		btnNewButton_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton_2.setBackground(new Color(0, 204, 204));
		btnNewButton_2.setBounds(173, 186, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setForeground(new Color(0, 102, 102));
		btnNewButton_1.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(0, 204, 204));
		btnNewButton_1.setBounds(29, 120, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setForeground(new Color(0, 102, 102));
		btnNewButton_1_1.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton_1_1.setBackground(new Color(102, 204, 204));
		btnNewButton_1_1.setBounds(173, 55, 97, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("New button");
		btnNewButton_1_2.setForeground(new Color(0, 102, 102));
		btnNewButton_1_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton_1_2.setBackground(new Color(0, 204, 204));
		btnNewButton_1_2.setBounds(173, 120, 97, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("New button");
		btnNewButton_1_3.setForeground(new Color(0, 102, 102));
		btnNewButton_1_3.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton_1_3.setBackground(new Color(0, 204, 204));
		btnNewButton_1_3.setBounds(317, 186, 97, 23);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("New button");
		btnNewButton_1_4.setForeground(new Color(0, 102, 102));
		btnNewButton_1_4.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton_1_4.setBackground(new Color(0, 204, 204));
		btnNewButton_1_4.setBounds(317, 120, 97, 23);
		contentPane.add(btnNewButton_1_4);
	}
}
