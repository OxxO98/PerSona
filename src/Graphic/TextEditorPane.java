package Graphic;

import Event.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextEditorPane extends JPanel{
			
	private MainFrame mainFrame;
	
	private JTextArea TextEditorArea = new JTextArea();	
	private JButton ApplyButton = new JButton("Apply");
	private JScrollPane ScrollPane = new JScrollPane();
	
	public TexttoTreeApplyHandler ApplyButtonHandler;
	
	public TextEditorPane(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

		this.setLayout(new BorderLayout());
		
		
		this.add(new JScrollPane(TextEditorArea), BorderLayout.CENTER);
		this.add(ApplyButton, BorderLayout.SOUTH);
		
		TextEditorArea.setTabSize(4);
		
		this.setVisible(true);
		ScrollPane.setVisible(true);
	}
	//¸Þ¼Òµå
	public void setEvent() {
		if(mainFrame.MMP == null) {
			if(mainFrame.AP == null) {
				if(mainFrame.TEP == null) {
					return;
				}
			}
		}
		ApplyButtonHandler = new TexttoTreeApplyHandler();
		ApplyButton.addActionListener(ApplyButtonHandler);	
	}
	public String getText() {
		return TextEditorArea.getText();
	}
	public void setText(String str) {
		TextEditorArea.setText(str);
	}
	public JButton getButton() {
		return ApplyButton;
	}
	//private
}
