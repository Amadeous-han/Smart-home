package Util;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

import View.*;
import View.login;

public class MenuBar {
	JMenuBar menuBar;
	JMenuItem menuItemTypeManagement;
	JMenuItem menuItemEquipmentManagement;
	JMenuItem menuItemUserManagement;
	JMenuItem menuItemFamalyManagement;
	JMenuItem menuItemExit;
	
	public MenuBar(JFrame frame) {
		
		menuBar = new JMenuBar();
		// 图书信息管理菜单项
				menuItemTypeManagement = new JMenuItem();	 
				setMenuItemTypeManagement(frame);
//			
//				// 图书借阅管理菜单项
				menuItemEquipmentManagement = new JMenuItem();
				setMenuEquipmentManagement(frame);
//				
//				// 用户信息更改菜单项
				menuItemUserManagement = new JMenuItem();
				setMenuItemUserManagement(frame);
//				
				menuItemFamalyManagement = new JMenuItem();
				setMenuItemFamalyManagement(frame);
//				
				// 退出系统菜单项
				menuItemExit = new JMenuItem();
				setMenuItemExit(frame);
					
				menuBar.add(menuItemTypeManagement);
//				menuBar.add(menuItemEquipmentManagement);
//				menuBar.add(menuItemUserManagement);
//				menuBar.add(menuItemFamalyManagement);
				menuBar.add(menuItemExit);
				
				frame.setJMenuBar(menuBar);
	}
	
	
	/**
	 * 设置退出系统菜单项
	 */
	private void setMenuItemExit(JFrame frame) {
		menuItemExit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new login();
			}
		});
	}


	private void setMenuItemTypeManagement(JFrame frame) {
		//menuItemChangUser.setIcon(new ImageIcon("res/menuItemChangePassword.jpg"));
		menuItemTypeManagement.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new TypeManagement();
			}
		});
	}

	private void setMenuItemFamalyManagement(JFrame frame) {
		//menuItemChangUser.setIcon(new ImageIcon("res/menuItemChangePassword.jpg"));
		menuItemFamalyManagement.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new FamilyManagement();
			}
		});
	}

	private void setMenuEquipmentManagement(JFrame frame) {
		menuItemEquipmentManagement.setIcon(new ImageIcon("res/menuBookCategoryManage.jpg"));
		menuItemEquipmentManagement.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new EquipmentManagement();
			}
		});
	}


	private void setMenuItemUserManagement(JFrame frame) {
		menuItemUserManagement.setIcon(new ImageIcon("res/menuBookInformationManage.jpg"));
		menuItemUserManagement.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);	
				new UserManagement();
			}
		});
	}
}
