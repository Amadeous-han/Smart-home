package View;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class TempChart {
	 //1-дһ��ChartPanel����
	 ChartPanel jframe;

	 //2-BarChart���޲����Ĺ��췽��
	public TempChart(int[] num) {
        DefaultCategoryDataset data=(DefaultCategoryDataset) getDataSet(num);
        JFreeChart chart=ChartFactory.createBarChart3D(
      		  "Temperature",  //ͼ�����
      		  "TemperatureRange",//Ŀ¼�����ʾ��ǩ 
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
          CategoryAxis domain =plot.getDomainAxis();
          //��ֱ������������
          //domain.setLabelFont(new Font("����", Font.BOLD, 16));
          //ˮƽ�ײ���������
          //domain.setLabelFont(new Font("����", Font.BOLD, 20));
          //��ȡ��״��
          ValueAxis rangeAxis=plot.getRangeAxis();
         // rangeAxis.setLabelFont(new Font("����", Font.BOLD, 16));
          //����lengend����
          //chart.getLegend().setItemFont(new Font("����", Font.BOLD, 16));
          //chart.getTitle().setFont(new Font("����", Font.BOLD, 16));
		 //��ʼ��Jframe
          //���þ���ͼƬ��˾��� 
//           rangeAxis.setUpperMargin(0.2); 
           //���þ���ͼƬ�Ҷ˾��� 
//          rangeAxis.setLowerMargin(0.2); 
              //�����ᾫ�� 
          BarRenderer3D renderer = new BarRenderer3D();
          plot.setRenderer(renderer);                //���޸ĺ������ֵ���浽ͼ��
          renderer.setDrawBarOutline(true);          //���ӱ߿���ɫ�Ƿ���ʾ
          renderer.setBaseOutlinePaint(Color.ORANGE);//���ӱ߿���ɫ       ����Ҫ�� renderer.setDrawBarOutline(true); ��ǰ����
          renderer.setWallPaint(Color.gray);         //��������ǽ����ɫ
          renderer.setMaximumBarWidth(0.08);         //�������ӿ��       ����Ĳ���param��һ����0-1��֮���С������ʾ���ӿ��ռ����ͼ���ȵİٷֱȡ�(������ͼ�������õ���600pt����Ҫ���ӵĿ��Ϊ6PT�����ó�0.01���ɡ�)
          renderer.setMinimumBarLength(0.1);         //�������Ӹ߶�
          renderer.setSeriesPaint(0,Color.ORANGE);   //����������ɫ
          renderer.setItemMargin(0);                 //����ÿ��������������ƽ������֮�����
          renderer.setBaseItemLabelsVisible(true);   //����������ʾ��Ӧ��Ϣ �Ƿ���ʾ
          renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); //����������ʾ��Ӧ��Ϣ
          renderer.setBaseItemLabelPaint(Color.BLACK);//������ֵ��ɫ��Ĭ�Ϻ�ɫ

//          renderer.setMaximumBarWidth(0.08); //�������ӿ�� 
//          renderer.setMinimumBarLength(0.1); //�������Ӹ߶� 
//           NumberAxis na = (NumberAxis) plot.getRangeAxis(); 
//              na.setAutoRangeIncludesZero(true); 
//          DecimalFormat df = new DecimalFormat("#0.000"); 
          //���������ݱ�ǩ����ʾ��ʽ 
         // na.setNumberFormatOverride(df); 
              //��������͸���� 
          //plot.setForegroundAlpha(1.0f); 
        jframe=new ChartPanel(chart);
        
		
	}
	
	//3-ͼ����������
	public static CategoryDataset getDataSet(int[] num) {
		 DefaultCategoryDataset data=new DefaultCategoryDataset();
		 //��������
		 //data.setValue(0, " ", "0-30");
		 data.setValue(num[0], "", "0-30");
		// data.setValue(0, "", "0-30");
		 //data.setValue(0, "", "31-60");
		 data.setValue(num[1], "", "31-60");
		// data.setValue(0, "", "31-60");
		// data.setValue(0, "", "61-100");
		 data.setValue(num[2], "", "61-100");
		 //data.setValue(0, "", "61-100");
	//	 data.setValue(20, "Shanghai", "Apple");
	//	 data.setValue(100, "Shanghai", "Banana");
	//	 data.setValue(100, "Shanghai", "WaterMalon");
	//	 data.setValue(100, "Guangzhou", "Apple");
	// data.setValue(100, "Guangzhou", "Banana");
	//	 data.setValue(100, "Guangzhou", "WaterMalon");
		 return data;
	}
	
	//4-����һ��ChartPanel
	public ChartPanel getPanel() {
		return jframe;
	}
	
public void chart(int[] num) {
	JFrame j=new JFrame();
	JDialog jd=new JDialog();
	jd.setBounds(50, 50, 600, 600);
	jd.add(new TempChart(num).getPanel());
	jd.setVisible(true);
}

//����ת�ӷ���
//	public static void main(String[] args) {
//		 int[] num=new int[3];
//		 num[0]=100;
//		 num[1]=200;
//		 num[2]=150;
//		 TempChart B= new TempChart(num);
//		 B.chart(num);
//	}
}
