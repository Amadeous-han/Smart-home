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
		buttonEquipment = new JButton("设备管理");
		setButtonEquipment(VId);	
		buttonData = new JButton("数据管理");
		buttonData.addActionListener(this);
		buttonEquipment.addActionListener(this);
		//this.add(buttonData);
		this.add(buttonEquipment);
		this. setTitle("欢迎登录到厂家管理界面");
		this.setLayout(new GridLayout(2,1));
		this.setSize(400, 200);
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        
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
					JOptionPane.showMessageDialog(null,"系统错误","错误"
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
