package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VendorInterface extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	JButton buttonEquipment,buttonData;
	public VendorInterface(String VId) {
		buttonEquipment = new JButton("�豸����");
		setButtonEquipment(VId);	
		buttonData = new JButton("���ݹ���");
		buttonData.addActionListener(this);
		buttonEquipment.addActionListener(this);
		//this.add(buttonData);
		this.add(buttonEquipment);
		this. setTitle("��ӭ��¼�����ҹ������");
		this.setLayout(new GridLayout(2,1));
		this.setSize(400, 200);
        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        
        this.setVisible(true); 
        
	}
	public void setButtonEquipment(String VId){
		buttonEquipment.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {	
				try {		
					frame.setVisible(false);
					new EquipmentManagementVendor(VId);	
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"ϵͳ����","����"
							, JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
