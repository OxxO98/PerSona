package Graphic;

import javax.swing.*;

import Event.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import MenuHandler.*;

public class ToolBar extends JToolBar{
	
	private JButton save = new JButton("save");
	private JButton open = new JButton("open");
	private JButton makeNew = new JButton("new");
	private JButton saveNew = new JButton("saveNew");
	
	private JButton apply = new JButton("apply");
	private JButton change = new JButton("change");
	
	private JButton exit = new JButton("exit");
	
	private Graphics2D vector;
	private Color ForeGroundColor = new Color(0xFFFFFF);
	private Color BackGroundColor = new Color(0x303030);
	
	public ToolBar() {
		this.add(makeNew);
		this.add(open);
		this.add(save);
		this.add(saveNew);

		this.add(apply);
		this.add(change);
		
		this.add(exit);
		
		this.setEvent();
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
	
	private void setEvent() {
		save.addActionListener(new SaveHandler());
		open.addActionListener(new OpenHandler());
		makeNew.addActionListener(new ResetNewHandler());
		saveNew.addActionListener(new SaveNewHandler());
		
		apply.addActionListener(new TexttoTreeApplyHandler());
		change.addActionListener(new ApplyAttributeHandler());
		
		exit.addActionListener(new ExitHandler());
	}
}
