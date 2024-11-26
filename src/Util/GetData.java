package Util;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GetData {
	public GetData(JFrame frame) {
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(900, 510);
		frame.setLocation(300,200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
}