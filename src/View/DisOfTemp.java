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
	
	 //写一个ChartPanel变量
	 ChartPanel jframe;
	 //2-BarChart的无参数的构造方法
	public DisOfTemp(int[] num) {
         DefaultCategoryDataset data=(DefaultCategoryDataset) getDataSet(num);
         JFreeChart chart=ChartFactory.createBarChart3D(
       		  "Temperature",  //图表标题
       		  "TempRange",//目录轴的显示标签 
       		  "Data Bulk",//数值轴的显示标签 
       		  data, 
       		  PlotOrientation.VERTICAL,  //图表方向 水平 垂直
       		  true,  //是否显示图例(对于简单的图表建议显示图例)
       		  false,//是否生成工具 
       		  false);  //是否生成网址链接
         //字体设置
            //获得图表区域对象
           CategoryPlot plot=chart.getCategoryPlot();
           //水平底部列表 

           BarRenderer3D renderer = new BarRenderer3D();
           plot.setRenderer(renderer);                //将修改后的属性值保存到图中
           renderer.setDrawBarOutline(true);          //柱子边框颜色是否显示
           renderer.setBaseOutlinePaint(Color.ORANGE);//柱子边框颜色       但是要在 renderer.setDrawBarOutline(true); 的前提下
           renderer.setWallPaint(Color.gray);         //设置柱子墙体颜色
           renderer.setMaximumBarWidth(0.08);    //设置柱子宽度       这里的参数param是一个（0-1）之间的小数，表示柱子宽度占整个图表宽度的百分比。
                                                                          //(比如你图表宽度设置的是600pt，想要柱子的宽度为6PT，设置成0.01即可。)
           renderer.setMinimumBarLength(0.1);         //设置柱子高度
           renderer.setSeriesPaint(0,Color.ORANGE);   //设置柱的颜色
           renderer.setItemMargin(0);                 //设置每个地区所包含的平行柱的之间距离
           renderer.setBaseItemLabelsVisible(true);   //在柱子上显示相应信息 是否显示
           renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); //在柱子上显示相应信息
           renderer.setBaseItemLabelPaint(Color.BLACK);//设置数值颜色，默认黑色

           jframe=new ChartPanel(chart);
	}
	//3-图表数据设置
	public static CategoryDataset getDataSet(int[] num) {
		 DefaultCategoryDataset data=new DefaultCategoryDataset();
		 data.setValue(num[0], "", "10-21");
		 data.setValue(num[1], "", "22-32");
		 data.setValue(num[2], "", "33-45");
		 return data;
	}
	//4-返回一个ChartPanel
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