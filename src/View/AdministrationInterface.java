package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Dao.*;
import Model.*;
import Action.*;
public class AdministrationInterface extends JFrame implements ActionListener{
	JFrame frame = new JFrame("系统管理员界面");
	JButton buttonUser, buttonFamily, buttonEquipment,buttonType,buttonData;
	public AdministrationInterface() {
		
		buttonUser = new JButton("用户管理");
		buttonFamily = new JButton("家庭管理");
		buttonEquipment = new JButton("设备管理");
		buttonType = new JButton("类型管理");
		buttonData = new JButton("数据管理");
		buttonUser.addActionListener(this);
		buttonFamily.addActionListener(this);
		buttonEquipment.addActionListener(this);
		buttonType.addActionListener(this);
		buttonData.addActionListener(this);
		this.add(buttonData);
		this.add(buttonEquipment);
		this.add(buttonFamily);
		this.add(buttonType);
		this.add(buttonUser);
		  Dimension preferredSize = new Dimension(400,100);
		  buttonUser.setPreferredSize(preferredSize );
		  buttonFamily.setPreferredSize(preferredSize );
		  buttonEquipment.setPreferredSize(preferredSize );
		  buttonType.setPreferredSize(preferredSize );
		  buttonData.setPreferredSize(preferredSize );
		  
		this. setTitle("欢迎登录到管理员界面");
		this.setLayout(new GridLayout(5,1));
        this.setSize(400, 300);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        
        this.setVisible(true);  //设置可见

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="用户管理")
			new UserManagement();
		else if (e.getActionCommand()=="家庭管理")
			new FamilyManagement();
		else if (e.getActionCommand()=="设备管理")
			new EquipmentManagement();
		else if (e.getActionCommand()=="类型管理")
			new TypeManagement();
		else if (e.getActionCommand()=="数据管理")
			new DataInformation();
		//else if (e.getActionCommand()=="数据管理")
	}
}
