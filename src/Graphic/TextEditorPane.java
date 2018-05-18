package Graphic;

import Event.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextEditorPane extends JPanel{
			
	protected JTextArea TextEditorArea = new JTextArea();	
	private JButton ApplyButton = new JButton("Apply");
	
	public TextEditorPane() {
		this.setLayout(new BorderLayout());
		
		this.add(TextEditorArea, BorderLayout.CENTER);
		this.add(ApplyButton, BorderLayout.SOUTH);

		ApplyButton.addActionListener(new TexttoTreeAppyHandler(this));
		this.setVisible(true);
	}
	//¸Þ¼Òµå
	public String getText() {
		return TextEditorArea.getText();
	}
	public JButton getButton() {
		return ApplyButton;
	}
	//private
}
