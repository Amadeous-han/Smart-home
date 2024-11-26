package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import Action.DataAction;
import Action.SearchByEid;
import Util.FrameOption;

public class DataSearch extends JFrame{
	JFrame frame = new JFrame("Search");
	 JPanel panel = new JPanel();
	 JPanel panel1 = new JPanel();
    
	JButton buttonSearchByEid, buttonSearchByEtype, buttonSearchByFamily,buttoncountByRelation;
	JButton buttondisWet ,buttondisTemp, buttondisLight,buttonmanyfamily;
	
	JTable table;
	// 显示表格的滚动面板
	
	DataAction dataAction;
	
	public DataSearch(){
		
		panel.setBounds(0, 0, 500, 400);
		panel1.setBounds(0, 400, 500, 100);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panel1);
		dataAction = new DataAction();
		panel.setLayout(new GridLayout(4,2));
		
		buttonSearchByEid = new JButton("SearchbyEid");
		setbuttonSearchByEid();
        buttonSearchByEtype = new JButton("SearchByEtype");
        setbuttonSearchByEtype();
        buttonSearchByFamily = new JButton("SearchByFamily");
        setbuttonSearchByFamily();
        buttoncountByRelation = new JButton("countByRelation");
        setbuttoncountByRelation();
        buttondisWet = new JButton("distributionOfWet");
        setbuttondisWet();
	    buttondisTemp = new JButton("distributionOfTemp");
	    setbuttondisTemp() ;
	    buttondisLight = new JButton("distributionOfLight");
	    setbuttondisLight();
	    buttonmanyfamily = new JButton("dataOfFamilies");
	    setbuttonmanyfamily();
	    
	    panel.add(buttonSearchByEid);
	    panel.add(buttonSearchByEtype);
	    panel.add(buttonSearchByFamily);
	    panel.add(buttoncountByRelation);
	    panel.add(buttondisLight);
	    panel.add(buttondisTemp);
	    panel.add(buttondisWet);
	    panel.add(buttonmanyfamily);
	    
	    frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(500, 510);
		frame.setLocation(300,200);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
	public void setbuttonSearchByEid() {
		buttonSearchByEid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchByEid() ;
			}	
		});
	}
	public void setbuttonSearchByEtype() {
		buttonSearchByEtype.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchByType();
			}
			
		});
	}
	public void setbuttonSearchByFamily() {
		buttonSearchByFamily.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchByFamily();
			}		
		});
	}
	public void setbuttoncountByRelation() {
		buttoncountByRelation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DataRelation();
			}		
		});
		
	}
	public void setbuttondisWet() {
		buttondisWet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new  DisOfWet();
			}		
		});
	}
	 public void setbuttondisTemp() {
		 buttondisTemp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new  DisOfTemp();
				}		
			});
	 }
	 public void setbuttondisLight() {
		 buttondisLight.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new  DisOfLight();
				}		
			});
	 }
	public void  setbuttonmanyfamily() {
		
	}
}
