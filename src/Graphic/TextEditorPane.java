package Graphic;

import javax.swing.*;
import java.awt.*;

class TextEditorPane extends JPanel{
			
	protected JTextArea TextEditorArea = new JTextArea();	
	private JButton ApplyButton = new JButton("Apply");
	
	public TextEditorPane() {
		this.setLayout(new BorderLayout());
		
		this.add(TextEditorArea, BorderLayout.CENTER);
		this.add(ApplyButton, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
}
