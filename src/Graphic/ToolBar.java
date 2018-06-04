package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ToolBar extends JToolBar{
	
	protected JButton save = new JButton("save");
	protected JButton open = new JButton("open");
	
	private Graphics2D vector;
	private Color ForeGroundColor = new Color(0xFFFFFF);
	private Color BackGroundColor = new Color(0x303030);
	
	public ToolBar() {
		this.add(save);
		this.add(open);
		
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		vector = (Graphics2D)g;
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Rectangle2D rect = new Rectangle2D.Double(2, 2, this.getWidth()-4, this.getHeight()-4);
		Stroke stroke = new BasicStroke(2);
		vector.setStroke(stroke);
		vector.draw(rect);
		vector.setPaint(ForeGroundColor);
		vector.fill(rect);
	}
}
