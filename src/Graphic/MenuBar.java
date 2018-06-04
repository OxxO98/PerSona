package Graphic;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
	
	private JMenu [] Menu = new JMenu[7];
	
	
	private Graphics2D vector;
	private Color ForeGroundColor = new Color(0xFFFFFF);
	private Color BackGroundColor = new Color(0x303030);
	
	public void paintComponent(Graphics g) {
		vector = (Graphics2D)g;
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Rectangle2D rect = new Rectangle2D.Double(2, 2, this.getWidth()-4, this.getHeight()-4);
		Stroke stroke = new BasicStroke(2);
		vector.setStroke(stroke);
		vector.draw(rect);
		vector.setPaint(ForeGroundColor);
		vector.fill(rect);
		
//		this.setLayout(null);
	}
	
	public MenuBar() {
		Menu[0] = new JMenu("File");
		Menu[1] = new JMenu("Edit");
		Menu[2] = new JMenu("Type");
		Menu[3] = new JMenu("Select");
		Menu[4] = new JMenu("View");
		Menu[5] = new JMenu("Window");
		Menu[6] = new JMenu("Help");
		
		Menu[0].add(new JMenuItem("货 颇老"));
		Menu[0].add(new JMenuItem("历厘"));
		Menu[6].add(new JMenuItem("档框富"));
		
		for(int i = 0; i < Menu.length; i++) {
			this.add(Menu[i]);
		}
		
		this.setVisible(true);
	}
}

