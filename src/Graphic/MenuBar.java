package Graphic;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenu typeMenu = new JMenu("Type");
	private JMenu selectMenu = new JMenu("Select");
	private JMenu viewMenu = new JMenu("View");
	private JMenu windowMenu = new JMenu("Window");
	private JMenu helpMenu = new JMenu("Help");
	
	public MenuBar() {
		fileMenu.add(new JMenuItem("�� ����"));
		fileMenu.add(new JMenuItem("����"));
		helpMenu.add(new JMenuItem("����"));
		
		this.add(fileMenu);
		this.add(editMenu);
		this.add(typeMenu);
		this.add(selectMenu);
		this.add(viewMenu);
		this.add(windowMenu);
		this.add(fileMenu);
		this.add(helpMenu);
		
		this.setVisible(true);
	}
}

