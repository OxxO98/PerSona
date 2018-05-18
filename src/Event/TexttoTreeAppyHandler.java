package Event;

import Graphic.TextEditorPane;
import TextEditorSystem.MakeTexttoTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TexttoTreeAppyHandler implements ActionListener {
	
	TextEditorPane PointEditorPane;
	
	public TexttoTreeAppyHandler(TextEditorPane PointEditorPane) {
		this.PointEditorPane = PointEditorPane;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getActionCommand() == "Apply") {
			MakeTexttoTree TexttoTree = new MakeTexttoTree(PointEditorPane);
		}
	}
}
