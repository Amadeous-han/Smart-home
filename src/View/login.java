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
	 
	 
	    // 数据库的用户名与密码，需要根据自己的设置
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
			 Manager=new JButton("系统管理员登录");
			 Vendor=new JButton("设备厂家登录");
			 //设置监听
			 Manager.addActionListener(this);
			 Vendor.addActionListener(this);
			 //设置标签
			 labTitle1 = new JLabel("I D :");
			 labTitle2 = new JLabel("密码:");
			 //id和密码框
			 Id= new JTextField(10);	//创建文本框和密码框
		     code = new JPasswordField(10);
		     //加入面板
		     pl1.add(labTitle1);
			 pl1.add(Id);
				
			 pl2.add(labTitle2);
			 pl2.add(code);
			 
			 pl3.add(Manager);
			 pl3.add(Vendor);
			 //加入frame
			 this.add(pl1);
			 this.add(pl2);
			 this.add(pl3);
			 
			 
			 this.setTitle("智慧家居后台登录");
		        this.setLayout(new GridLayout(3,1));
		        this.setSize(400, 200);   //设置窗体大小
		        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
		        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
		        
		        this.setVisible(true);  //设置可见
		        this.setResizable(false);	//设置不可拉伸大小
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand()=="系统管理员登录")
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
					JOptionPane.showMessageDialog(null, "管理员成功登录","提示",JOptionPane.PLAIN_MESSAGE);
					//管理员界面
					new AdministrationInterface();
				}
				else if(success==0)
					 JOptionPane.showMessageDialog(null, "密码输入错误","错误",JOptionPane.ERROR_MESSAGE);
				else if(success==-1)
					 JOptionPane.showMessageDialog(null, "ID输入错误","错误",JOptionPane.ERROR_MESSAGE);
				
			}
			else if(e.getActionCommand()=="设备厂家登录")
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
					JOptionPane.showMessageDialog(null, "设备厂家成功登录","提示",JOptionPane.PLAIN_MESSAGE);
					new VendorInterface(Id.getText());
					//设备厂家界面
				}
				else if(success==0)
					 JOptionPane.showMessageDialog(null, "密码输入错误","错误",JOptionPane.ERROR_MESSAGE);
				else if(success==-1)
					 JOptionPane.showMessageDialog(null, "ID输入错误","错误",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		
}
