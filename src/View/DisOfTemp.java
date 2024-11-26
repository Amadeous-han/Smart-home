package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import Action.DataAction;
import Util.DisFrame;


public class DisOfTemp {
	JFrame frame = new JFrame("disOfTemp");
	Container container = frame.getContentPane();
	
	JTextField startTime, finishTime;
	JButton buttonSearch;
	JLabel label1, label2;
	DataAction dataAction;
	
	 //дһ��ChartPanel����
	 ChartPanel jframe;
	 //2-BarChart���޲����Ĺ��췽��
	public DisOfTemp(int[] num) {
         DefaultCategoryDataset data=(DefaultCategoryDataset) getDataSet(num);
         JFreeChart chart=ChartFactory.createBarChart3D(
       		  "Temperature",  //ͼ�����
       		  "TempRange",//Ŀ¼�����ʾ��ǩ 
       		  "Data Bulk",//��ֵ�����ʾ��ǩ 
       		  data, 
       		  PlotOrientation.VERTICAL,  //ͼ���� ˮƽ ��ֱ
       		  true,  //�Ƿ���ʾͼ��(���ڼ򵥵�ͼ������ʾͼ��)
       		  false,//�Ƿ����ɹ��� 
       		  false);  //�Ƿ�������ַ����
         //��������
            //���ͼ���������
           CategoryPlot plot=chart.getCategoryPlot();
           //ˮƽ�ײ��б� 

           BarRenderer3D renderer = new BarRenderer3D();
           plot.setRenderer(renderer);                //���޸ĺ������ֵ���浽ͼ��
           renderer.setDrawBarOutline(true);          //���ӱ߿���ɫ�Ƿ���ʾ
           renderer.setBaseOutlinePaint(Color.ORANGE);//���ӱ߿���ɫ       ����Ҫ�� renderer.setDrawBarOutline(true); ��ǰ����
           renderer.setWallPaint(Color.gray);         //��������ǽ����ɫ
           renderer.setMaximumBarWidth(0.08);    //�������ӿ��       ����Ĳ���param��һ����0-1��֮���С������ʾ���ӿ��ռ����ͼ���ȵİٷֱȡ�
                                                                          //(������ͼ�������õ���600pt����Ҫ���ӵĿ��Ϊ6PT�����ó�0.01���ɡ�)
           renderer.setMinimumBarLength(0.1);         //�������Ӹ߶�
           renderer.setSeriesPaint(0,Color.ORANGE);   //����������ɫ
           renderer.setItemMargin(0);                 //����ÿ��������������ƽ������֮�����
           renderer.setBaseItemLabelsVisible(true);   //����������ʾ��Ӧ��Ϣ �Ƿ���ʾ
           renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); //����������ʾ��Ӧ��Ϣ
           renderer.setBaseItemLabelPaint(Color.BLACK);//������ֵ��ɫ��Ĭ�Ϻ�ɫ

           jframe=new ChartPanel(chart);
	}
	//3-ͼ����������
	public static CategoryDataset getDataSet(int[] num) {
		 DefaultCategoryDataset data=new DefaultCategoryDataset();
		 data.setValue(num[0], "", "10-21");
		 data.setValue(num[1], "", "22-32");
		 data.setValue(num[2], "", "33-45");
		 return data;
	}
	//4-����һ��ChartPanel
	public ChartPanel getPanel() {
		return jframe;
	}
	
	public DisOfTemp() {
		dataAction = new DataAction();
		frame.setLayout(null);
		startTime =new JTextField();
		setStartTime();
		finishTime = new JTextField();
		setFinishTime();
		buttonSearch = new JButton("Search!");
		setbuttonSearch();
		label1 = new JLabel("From: ");
		label1.setBounds(50, 70, 80, 25);
		label2 = new JLabel("To: ");
		label2.setBounds(320, 70, 80, 25);
		
		container.add(buttonSearch);
		container.add(startTime);
		container.add(finishTime);
		container.add(label1);
		container.add(label2);
		
		new DisFrame(frame);
		
	}
		
	public void setbuttonSearch() {
		buttonSearch.setBounds(600, 65, 100, 30);
		buttonSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			int[] num;
			try {
				num = dataAction.getDisOfTemp(startTime, finishTime);
				JDialog jd=new JDialog();
				jd.setBounds(400, 170, 600, 600);
				jd.add(new DisOfTemp(num).getPanel());
				jd.setVisible(true);		
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			}		
		});
	}
	public void setStartTime() {
		startTime.setBounds(100, 70, 150, 25);
	}
	public void setFinishTime() {
		finishTime.setBounds(350, 70, 160, 25);
	}
}