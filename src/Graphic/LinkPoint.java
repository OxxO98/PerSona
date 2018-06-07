package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

import System.MainSystem;

import java.awt.*;

public class LinkPoint {
	private double x, y;
	private boolean link;
	
	private LinkLine Line;
	
	public LinkPoint linkedPoint = null;	//?모름
	public MapNode includedNode = null; 	//this
	//생성자
	public LinkPoint(double x, double y){
		this.x = x;
		this.y = y;
		this.link = false;
	}
	//메소드
	//get
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public boolean getLink() {
		return this.link;
	}
	//set
	public void setLink(boolean b) {
		this.link = b;
	}
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	//express
	public void expressLine() {
		if(this.link == false) {
			return;
		}
		else {
			System.out.println("link");
			if(Line == null) {
				Line = new LinkLine();
			}
			
			double width = Math.abs(x - linkedPoint.x);
			double height = Math.abs(y - linkedPoint.y);
			double nodeX, nodeY;
			
			if(x >= linkedPoint.x) {
				nodeX = linkedPoint.x;
				if(y >= linkedPoint.y) {
					nodeY = linkedPoint.y;
					Line.setVectorNode(true);
				}
				else {
					nodeY = y;
					Line.setVectorNode(false);
				}
			}
			else {
				nodeX = x;
				if(y >= linkedPoint.y) {
					nodeY = linkedPoint.y;
					Line.setVectorNode(false);
				}
				else {
					nodeY = y;
					Line.setVectorNode(true);
				}
			}
			
			this.Line.setLocation((int)nodeX, (int)nodeY);
			this.Line.setSize(new Dimension((int)width, (int)height));
			
			MainSystem.getFrame().MMP.add(this.Line);
			this.Line.setVisible(true);
		}
	}
}

class LinkLine extends JLabel {
	

	private double ArcSize = 100;
	private int StrokeWidth = 3;
	
	private boolean vectorNode = true;
	
	public void setArcSize(double ArcSize) {
		this.ArcSize = ArcSize;
	}
	public void setStrokeWidth(int StrokeWidth) {
		this.StrokeWidth = StrokeWidth;
	}
	public void setVectorNode(boolean b) {
		this.vectorNode = b;
	}
	
	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
		Graphics2D vector = (Graphics2D)g;
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//생성준비
		Stroke stroke = new BasicStroke(StrokeWidth);
		Line2D line1, line2, lineM;
		Arc2D arc1, arc2;
		Path2D LinkPath = new Path2D.Double();
		
		this.setArcSize(this.getWidth()/5);
		
		if(vectorNode == true) {
			//반비례 대각선 위에서 아래로
			/*
			 * --
			 * 	 |
			 *    --
			 */
			line1 = new Line2D.Double(0, StrokeWidth, this.getWidth()/2-ArcSize, StrokeWidth);
			arc1 = new Arc2D.Double(this.getWidth()/2-ArcSize, StrokeWidth, ArcSize, ArcSize, 90, -90, Arc2D.OPEN);
			lineM = new Line2D.Double(this.getWidth()/2, ArcSize, this.getWidth()/2, this.getHeight()-ArcSize);
			arc2 = new Arc2D.Double(this.getWidth()/2, this.getHeight()-ArcSize-StrokeWidth, ArcSize, ArcSize, 180, 90, Arc2D.OPEN);
			line2 = new Line2D.Double(this.getWidth()/2+ArcSize, this.getHeight()-StrokeWidth, this.getWidth(), this.getHeight()-StrokeWidth);
		}
		else {
			//비례 대각선 위에서 아래로
			/*
			 * 	  |
			 * 	--
			 * |  
			 */
			line1 = new Line2D.Double(this.getWidth()-StrokeWidth, 0, this.getWidth()-StrokeWidth, this.getHeight()/2-ArcSize);
			arc1 = new Arc2D.Double(this.getWidth()-ArcSize-StrokeWidth ,this.getHeight()/2-ArcSize ,ArcSize, ArcSize, 0, -90, Arc2D.OPEN);
			lineM = new Line2D.Double(ArcSize, this.getHeight()/2, this.getWidth()-ArcSize, this.getHeight()/2);
			arc2 = new Arc2D.Double(StrokeWidth ,this.getHeight()/2 ,ArcSize, ArcSize, 90, 90, Arc2D.OPEN);
			line2 = new Line2D.Double(StrokeWidth, this.getHeight()/2+ArcSize, StrokeWidth, this.getHeight());
		}
		
		LinkPath.append(line1, true);
		LinkPath.append(arc1, true);
		LinkPath.append(lineM, true);
		LinkPath.append(arc2, true);
		LinkPath.append(line2, true);
		
		vector.setStroke(stroke);
		vector.draw(LinkPath);
	}
}