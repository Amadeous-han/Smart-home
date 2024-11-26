package Util;


import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class DisFrame {
 public DisFrame(JFrame frame) {
		
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(800, 210);
		frame.setLocation(300,200);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);			
	}
}
