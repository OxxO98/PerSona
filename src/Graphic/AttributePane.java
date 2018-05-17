package Graphic;

import java.awt.BorderLayout;

import javax.swing.*;

public class AttributePane extends JPanel {
	protected JPanel AtributeArea = new JPanel();
	private JButton ApplyButton = new JButton("Apply");
	
	public AttributePane() {
		this.setLayout(new BorderLayout());
		
		this.add(AtributeArea, BorderLayout.CENTER);
		this.add(ApplyButton, BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
