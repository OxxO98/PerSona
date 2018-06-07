package Graphic;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import Event.ApplyAttributeHandler;

public class AttributePane extends JPanel {
	
	private MainFrame mainFrame;
	
	private JPanel AttributeArea = new JPanel();
	private JButton ApplyButton = new JButton("Apply");
	private JScrollPane ScrollPane;
	public JLabel [] attributeLabel = new JLabel[6];
	public JTextField [] attributeText = new JTextField[6];
	public MapNode SelectedNode;
	
	public AttributePane(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		this.setLayout(new BorderLayout());
		
		this.add(new JScrollPane(AttributeArea), BorderLayout.CENTER);
		this.add(ApplyButton, BorderLayout.SOUTH);
		ApplyButton.addActionListener(new ApplyAttributeHandler());
		
		attributeLabel[0] = new JLabel("TexT : ");
		attributeLabel[1] = new JLabel("X :");
		attributeLabel[2] = new JLabel("Y :");
		attributeLabel[3] = new JLabel("W :");
		attributeLabel[4] = new JLabel("H :");
		attributeLabel[5] = new JLabel("Color :");
		
		attributeText[0] = new JTextField();
		attributeText[0].setEditable(false);
		attributeText[1] = new JTextField();
		attributeText[2] = new JTextField();
		attributeText[3] = new JTextField();
		attributeText[4] = new JTextField();
		attributeText[5] = new JTextField();
		
		AttributeArea.setLayout(new GridLayout(6, 2));
		
		for(int i = 0; i < 6; i++) {
			attributeLabel[i].setHorizontalAlignment(JTextField.CENTER);
			AttributeArea.add(attributeLabel[i], i*2);
			AttributeArea.add(attributeText[i], i*2+1);
		}
		
		this.setVisible(true);
	}
	//¸Þ¼Òµå
}
