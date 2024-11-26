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
	 //1-写一个ChartPanel变量
	 ChartPanel jframe;

	 //2-BarChart的无参数的构造方法
	public TempChart(int[] num) {
        DefaultCategoryDataset data=(DefaultCategoryDataset) getDataSet(num);
        JFreeChart chart=ChartFactory.createBarChart3D(
      		  "Temperature",  //图表标题
      		  "TemperatureRange",//目录轴的显示标签 
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
          CategoryAxis domain =plot.getDomainAxis();
          //垂直标题字体设置
          //domain.setLabelFont(new Font("黑体", Font.BOLD, 16));
          //水平底部标题设置
          //domain.setLabelFont(new Font("黑体", Font.BOLD, 20));
          //获取柱状体
          ValueAxis rangeAxis=plot.getRangeAxis();
         // rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 16));
          //设置lengend字体
          //chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 16));
          //chart.getTitle().setFont(new Font("黑体", Font.BOLD, 16));
		 //初始化Jframe
          //设置距离图片左端距离 
//           rangeAxis.setUpperMargin(0.2); 
           //设置距离图片右端距离 
//          rangeAxis.setLowerMargin(0.2); 
              //数据轴精度 
          BarRenderer3D renderer = new BarRenderer3D();
          plot.setRenderer(renderer);                //将修改后的属性值保存到图中
          renderer.setDrawBarOutline(true);          //柱子边框颜色是否显示
          renderer.setBaseOutlinePaint(Color.ORANGE);//柱子边框颜色       但是要在 renderer.setDrawBarOutline(true); 的前提下
          renderer.setWallPaint(Color.gray);         //设置柱子墙体颜色
          renderer.setMaximumBarWidth(0.08);         //设置柱子宽度       这里的参数param是一个（0-1）之间的小数，表示柱子宽度占整个图表宽度的百分比。(比如你图表宽度设置的是600pt，想要柱子的宽度为6PT，设置成0.01即可。)
          renderer.setMinimumBarLength(0.1);         //设置柱子高度
          renderer.setSeriesPaint(0,Color.ORANGE);   //设置柱的颜色
          renderer.setItemMargin(0);                 //设置每个地区所包含的平行柱的之间距离
          renderer.setBaseItemLabelsVisible(true);   //在柱子上显示相应信息 是否显示
          renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); //在柱子上显示相应信息
          renderer.setBaseItemLabelPaint(Color.BLACK);//设置数值颜色，默认黑色

//          renderer.setMaximumBarWidth(0.08); //设置柱子宽度 
//          renderer.setMinimumBarLength(0.1); //设置柱子高度 
//           NumberAxis na = (NumberAxis) plot.getRangeAxis(); 
//              na.setAutoRangeIncludesZero(true); 
//          DecimalFormat df = new DecimalFormat("#0.000"); 
          //数据轴数据标签的显示格式 
         // na.setNumberFormatOverride(df); 
              //设置柱的透明度 
          //plot.setForegroundAlpha(1.0f); 
        jframe=new ChartPanel(chart);
        
		
	}
	
	//3-图表数据设置
	public static CategoryDataset getDataSet(int[] num) {
		 DefaultCategoryDataset data=new DefaultCategoryDataset();
		 //设置数据
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
	
	//4-返回一个ChartPanel
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

//调用转接方法
//	public static void main(String[] args) {
//		 int[] num=new int[3];
//		 num[0]=100;
//		 num[1]=200;
//		 num[2]=150;
//		 TempChart B= new TempChart(num);
//		 B.chart(num);
//	}
}
