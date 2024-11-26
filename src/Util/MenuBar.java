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
		// ͼ����Ϣ����˵���
				menuItemTypeManagement = new JMenuItem();	 
				setMenuItemTypeManagement(frame);
//			
//				// ͼ����Ĺ���˵���
				menuItemEquipmentManagement = new JMenuItem();
				setMenuEquipmentManagement(frame);
//				
//				// �û���Ϣ���Ĳ˵���
				menuItemUserManagement = new JMenuItem();
				setMenuItemUserManagement(frame);
//				
				menuItemFamalyManagement = new JMenuItem();
				setMenuItemFamalyManagement(frame);
//				
				// �˳�ϵͳ�˵���
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
	 * �����˳�ϵͳ�˵���
	 */
	private void setMenuItemExit(JFrame frame) {
		menuItemExit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// ʹ�����岻�ɼ�
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
				// ʹ�����岻�ɼ�
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
				// ʹ�����岻�ɼ�
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
				// ʹ�����岻�ɼ�
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
				// ʹ�����岻�ɼ�
				frame.setVisible(false);	
				new UserManagement();
			}
		});
	}
}
