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
	JFrame frame = new JFrame("ϵͳ����Ա����");
	JButton buttonUser, buttonFamily, buttonEquipment,buttonType,buttonData;
	public AdministrationInterface() {
		
		buttonUser = new JButton("�û�����");
		buttonFamily = new JButton("��ͥ����");
		buttonEquipment = new JButton("�豸����");
		buttonType = new JButton("���͹���");
		buttonData = new JButton("���ݹ���");
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
		  
		this. setTitle("��ӭ��¼������Ա����");
		this.setLayout(new GridLayout(5,1));
        this.setSize(400, 300);   //���ô����С
        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        
        this.setVisible(true);  //���ÿɼ�

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="�û�����")
			new UserManagement();
		else if (e.getActionCommand()=="��ͥ����")
			new FamilyManagement();
		else if (e.getActionCommand()=="�豸����")
			new EquipmentManagement();
		else if (e.getActionCommand()=="���͹���")
			new TypeManagement();
		else if (e.getActionCommand()=="���ݹ���")
			new DataInformation();
		//else if (e.getActionCommand()=="���ݹ���")
	}
}
