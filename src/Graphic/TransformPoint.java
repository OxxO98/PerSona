package Graphic;

import javax.swing.*;

import Event.TransformHandler;
import System.MainSystem;

import java.awt.*;
import java.awt.geom.*;

public class TransformPoint extends JLabel {
	
	private Graphics2D vector;
	private int size = 10;
	private int x, y;
	private Color color = new Color(0xA0A0A0);
	private boolean init = false;
	
	private int attribute;
	
	private boolean drew = false;
	/*
	 * 		7	0	1
	 * 		6		2
	 * 		5	4	3
	 */
	public TransformPoint(int atr, int x, int y, int width, int height) {
		this.attribute = atr;
		
		this.resetTransform(atr, x, y, width, height);
	}
	
	public void paintComponent(Graphics g) {
		vector = (Graphics2D)g;
		//repaint할 일 없겠지
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Rectangle2D rect = new Rectangle2D.Double(0, 0, size, size);
		vector.setColor(color);
		vector.fill(rect);
	}
	
	public void express() {
		this.setSize(size, size);
		this.setLocation(x, y);
		
		if(init == false) {
			TransformHandler initTransformHandler = new TransformHandler();
			this.addMouseMotionListener(initTransformHandler);
			this.addMouseListener(initTransformHandler);
			init = true;
		}
	}
	//get
	public int getAttribute() {
		return this.attribute;
	}
	public int getNodeX() {
		return this.x;
	}
	public int getNodeY() {
		return this.y;
	}
	public int getPointSize() {
		return this.size;
	}
	//set
	public void setXY(int x, int y) {
		this.x = x-size/2;
		this.y = y-size/2;
		//???ㅇㅇ 잘 사용하지 맙시다.
	}
	public void setNodeX(int x) {
		this.x = x;
	}
	public void setNodeY(int y) {
		this.y = y;
	}
	public void setAttribute(int atr) {
		this.attribute = atr;
	}
	public void resetTransform(int attribute, int x, int y, int width, int height) {
		
		switch(attribute) {
			case 0 :
				this.setXY(x+width/2, y);
				break;
			case 1 :
				this.setXY(x+width, y);
				break;
			case 2 :
				this.setXY(x+width, y+height/2);
				break;
			case 3 :
				this.setXY(x+width, y+height);
				break;
			case 4 :
				this.setXY(x+width/2, y+height);
				break;
			case 5 :
				this.setXY(x, y+height);
				break;
			case 6 :
				this.setXY(x, y+height/2);
				break;
			case 7 :
				this.setXY(x, y);
				break;
		}
	}
	public void setTransformNode(int atr, int x, int y, int width, int height) {
		int Psize = size/2;
				
		switch(atr) {
			case 0 :
				this.setLocation(x+width/2-Psize, y-Psize);
				break;
			case 1 :
				this.setLocation(x+width-Psize, y-Psize);
				break;
			case 2 :
				this.setLocation(x+width-Psize, y+height/2-Psize);
				break;
			case 3 :
				this.setLocation(x+width-Psize, y+height-Psize);
				break;
			case 4 : 
				this.setLocation(x+width/2-Psize, y+height-Psize);
				break;
			case 5 :
				this.setLocation(x-Psize, y+height-Psize);
				break;
			case 6 :
				this.setLocation(x-Psize, y+height/2-Psize);
				break;
			case 7 :
				this.setLocation(x-Psize, y-Psize);
				break;
		}	
	}
}

class CenterPoint extends JLabel {
	
	private Graphics2D vector;
	private int size = 20;
	private int centerX, centerY;
	private int x, y;
	
	public void paintComponent(Graphics g) {
		vector = (Graphics2D)g;
		//repaint할 일 없겠지
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Ellipse2D ellipse = new Ellipse2D.Double(1, 1, size-1, size-1);
		Stroke stroke = new BasicStroke(1);
		
		vector.setStroke(stroke);
		vector.draw(ellipse);
	}
}