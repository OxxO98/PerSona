package Graphic;

import java.awt.BorderLayout;

import javax.swing.*;

public class AttributePane extends JPanel {
	
	private MainFrame mainFrame;
	
	protected JPanel AtributeArea = new JPanel();
	private JButton ApplyButton = new JButton("Apply");
	
	
	public AttributePane(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		this.setLayout(new BorderLayout());
		
		this.add(AtributeArea, BorderLayout.CENTER);
		this.add(ApplyButton, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	//¸Þ¼Òµå
}
