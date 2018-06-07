package Graphic;

import javax.swing.*;
import java.awt.*;

public class MindMapPane extends JPanel {
	
	private MainFrame mainFrame;
	private JScrollPane ScrollPane = new JScrollPane();
	
	public MindMapPane(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		this.setBackground(new Color(0xFFFFFF));
		this.setLayout(null);
		
		this.setVisible(true);
	}
	//¸Þ¼Òµå
}
