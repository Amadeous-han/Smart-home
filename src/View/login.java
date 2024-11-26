package View;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import View.*;
import Dao.*;
import Action.*;
public class login extends JFrame implements ActionListener {
	    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	 
	 
	    // ���ݿ���û��������룬��Ҫ�����Լ�������
	    static final String USER = "root";
	    static final String PASS = "2000108";
		JPanel pl1,pl2,pl3;
		JButton Manager,Vendor;
		JTextField Id;
		JPasswordField code;
		JLabel labTitle1,labTitle2; 
		public login() {
			 //title
			 pl1=new JPanel();
			 pl2=new JPanel();
			 pl3=new JPanel();
			 Manager=new JButton("ϵͳ����Ա��¼");
			 Vendor=new JButton("�豸���ҵ�¼");
			 //���ü���
			 Manager.addActionListener(this);
			 Vendor.addActionListener(this);
			 //���ñ�ǩ
			 labTitle1 = new JLabel("I D :");
			 labTitle2 = new JLabel("����:");
			 //id�������
			 Id= new JTextField(10);	//�����ı���������
		     code = new JPasswordField(10);
		     //�������
		     pl1.add(labTitle1);
			 pl1.add(Id);
				
			 pl2.add(labTitle2);
			 pl2.add(code);
			 
			 pl3.add(Manager);
			 pl3.add(Vendor);
			 //����frame
			 this.add(pl1);
			 this.add(pl2);
			 this.add(pl3);
			 
			 
			 this.setTitle("�ǻۼҾӺ�̨��¼");
		        this.setLayout(new GridLayout(3,1));
		        this.setSize(400, 200);   //���ô����С
		        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
		        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
		        
		        this.setVisible(true);  //���ÿɼ�
		        this.setResizable(false);	//���ò��������С
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand()=="ϵͳ����Ա��¼")
			{
				int success=-1;
				AdministrationAction log=new AdministrationAction();
				String[] columname= {"Aid","Aname","Acode"};
				Object[][] result = null;
				try {
					result = log.initializTable(columname);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
				   success=log.Denglu(result,Id.getText(), String.valueOf( code.getPassword()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(success==1) {
					JOptionPane.showMessageDialog(null, "����Ա�ɹ���¼","��ʾ",JOptionPane.PLAIN_MESSAGE);
					//����Ա����
					new AdministrationInterface();
				}
				else if(success==0)
					 JOptionPane.showMessageDialog(null, "�����������","����",JOptionPane.ERROR_MESSAGE);
				else if(success==-1)
					 JOptionPane.showMessageDialog(null, "ID�������","����",JOptionPane.ERROR_MESSAGE);
				
			}
			else if(e.getActionCommand()=="�豸���ҵ�¼")
			{
				int success=-1;
				VendorAction log=new VendorAction();
				String[] columname= {"Aid","Aname","Acode"};
				Object[][] result = null;
				try {
					result = log.initializTable(columname);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
				   success=log.Denglu(result,Id.getText(), String.valueOf( code.getPassword()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(success==1) {
					JOptionPane.showMessageDialog(null, "�豸���ҳɹ���¼","��ʾ",JOptionPane.PLAIN_MESSAGE);
					new VendorInterface(Id.getText());
					//�豸���ҽ���
				}
				else if(success==0)
					 JOptionPane.showMessageDialog(null, "�����������","����",JOptionPane.ERROR_MESSAGE);
				else if(success==-1)
					 JOptionPane.showMessageDialog(null, "ID�������","����",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		
}
