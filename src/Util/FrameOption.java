package Util;

import javax.swing.*;

public class FrameOption {
	
	public FrameOption(JFrame frame) {
		
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(800, 508);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

}
