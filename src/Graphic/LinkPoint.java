package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

import System.MainSystem;

import java.awt.*;

public class LinkPoint {
	private double x, y;
	private boolean link;
	
	public LinkLine Line;
	
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
			
			double width = Math.abs(linkedPoint.x - x), height = Math.abs(linkedPoint.y - y);
			double nodeX = x, nodeY = y;
			//this
			double CTx = includedNode.getNodeX() + includedNode.getNodeWidth()/2;
			double CTy = includedNode.getNodeY() + includedNode.getNodeHeight()/2;
			//linked
			double CLx = linkedPoint.includedNode.getNodeX() + linkedPoint.includedNode.getNodeWidth()/2;
			double CLy = linkedPoint.includedNode.getNodeY() + linkedPoint.includedNode.getNodeHeight()/2;
			
			//setting
			if(Math.abs(CLy-CTy) >= Math.abs(CTx-CLx)) {
				if(CTx > CLx && CTy < CLy) {
					//1
					Line.setVectorNode(1);
					nodeX = linkedPoint.includedNode.criteria[0].x;
					nodeY = includedNode.criteria[2].y;
					width = Math.abs(linkedPoint.includedNode.criteria[0].x - includedNode.criteria[2].x); 
					height = Math.abs(linkedPoint.includedNode.criteria[0].y - includedNode.criteria[2].y);
				}
				else if(CTx > CLx && CTy > CLy){
					//5
					Line.setVectorNode(3);
					nodeX = linkedPoint.includedNode.criteria[2].x;
					nodeY = linkedPoint.includedNode.criteria[2].y;
					width = Math.abs(linkedPoint.includedNode.criteria[2].x - includedNode.criteria[0].x); 
					height = Math.abs(linkedPoint.includedNode.criteria[2].y - includedNode.criteria[0].y);
				}
				else if(CTx < CLx && CTy < CLy) {
					//11
					Line.setVectorNode(3);
					nodeX = includedNode.criteria[2].x;
					nodeY = includedNode.criteria[2].y;
					width = Math.abs(linkedPoint.includedNode.criteria[0].x - includedNode.criteria[2].x); 
					height = Math.abs(linkedPoint.includedNode.criteria[0].y - includedNode.criteria[2].y);
				}
				else if(CTx < CLx && CTy > CLy){
					//7
					Line.setVectorNode(1);
					nodeX = includedNode.criteria[0].x;
					nodeY = linkedPoint.includedNode.criteria[2].y;
					width = Math.abs(linkedPoint.includedNode.criteria[2].x - includedNode.criteria[0].x); 
					height = Math.abs(linkedPoint.includedNode.criteria[2].y - includedNode.criteria[0].y);
				}
				
			}
			else if(Math.abs(CLy-CTy) < Math.abs(CTx-CLx)) {
				if(CTx > CLx && CTy < CLy) {
					//2
					Line.setVectorNode(2);
					nodeX = linkedPoint.includedNode.criteria[1].x;
					nodeY = includedNode.criteria[3].y;
					width = Math.abs(linkedPoint.includedNode.criteria[1].x - includedNode.criteria[3].x); 
					height = Math.abs(linkedPoint.includedNode.criteria[1].y - includedNode.criteria[3].y);
				}
				else if(CTx > CLx && CTy > CLy){
					//4
					Line.setVectorNode(0);
					nodeX = linkedPoint.includedNode.criteria[1].x;
					nodeY = linkedPoint.includedNode.criteria[1].y;
					width = Math.abs(linkedPoint.includedNode.criteria[1].x - includedNode.criteria[3].x); 
					height = Math.abs(linkedPoint.includedNode.criteria[1].y - includedNode.criteria[3].y);
				}
				else if(CTx < CLx && CTy < CLy) {
					//10
					Line.setVectorNode(0);
					nodeX = includedNode.criteria[1].x;
					nodeY = includedNode.criteria[1].y;
					width = Math.abs(linkedPoint.includedNode.criteria[3].x - includedNode.criteria[1].x); 
					height = Math.abs(linkedPoint.includedNode.criteria[3].y - includedNode.criteria[1].y);
				}
				else if(CTx < CLx && CTy > CLy){
					//8
					Line.setVectorNode(2);
					nodeX = includedNode.criteria[1].x;
					nodeY = linkedPoint.includedNode.criteria[3].y;
					width = Math.abs(linkedPoint.includedNode.criteria[3].x - includedNode.criteria[1].x); 
					height = Math.abs(linkedPoint.includedNode.criteria[3].y - includedNode.criteria[1].y);
				}
			}
			else if(CTx == CLx) {
				//0,6
				if(CTy < CLy) {
					Line.setVectorNode(5);
					nodeX = includedNode.criteria[2].x;
					nodeY = includedNode.criteria[2].y;
					width = 5;
					height = Math.abs(linkedPoint.includedNode.criteria[0].y - includedNode.criteria[2].y);
				}
				else {
					Line.setVectorNode(5);
					nodeX = linkedPoint.includedNode.criteria[2].x;
					nodeY = linkedPoint.includedNode.criteria[2].y;
					width = 5;
					height = Math.abs(linkedPoint.includedNode.criteria[2].y - includedNode.criteria[0].y);
				}
			}
			else if(CTy == CLy) {
				//3,9
				if(CTx > CLx) {
					Line.setVectorNode(4);
					nodeX = linkedPoint.includedNode.criteria[1].x;
					nodeY = linkedPoint.includedNode.criteria[1].y;
					width = Math.abs(linkedPoint.includedNode.criteria[1].x - includedNode.criteria[3].x); 
					height = 5;
				}
				else {
					Line.setVectorNode(4);
					nodeX = includedNode.criteria[3].x;
					nodeY = includedNode.criteria[3].y;
					width = Math.abs(linkedPoint.includedNode.criteria[1].x - includedNode.criteria[3].x); 
					height = 5;
				}
			}
			//
			
			this.Line.setXY((int)nodeX, (int)nodeY);
			this.Line.setDimension(new Dimension((int)width, (int)height));
			this.Line.setLinkPath();
		}
	}
}

class LinkLine{
	/*
	 * VectorNode
	 * 		0	대각선	y=-x
	 * 		1	대각선	y=x
	 * 		2	대칭		
	 * 		3	대칭
	 * 		4	직선
	 * 		5	직선
	 */

	private double ArcSize = 100;
	private int StrokeWidth = 3;
	
	private Stroke stroke = new BasicStroke(StrokeWidth);
	private Line2D line1, line2, lineM;
	private Arc2D arc1, arc2;
	private Path2D LinkPath = new Path2D.Double();
	
	private int x, y, width, height;
	
	private int vectorNode = 0;
	
	public void setArcSize(double ArcSize) {
		this.ArcSize = ArcSize;
	}
	public double getArcSize() {
		return this.ArcSize;
	}
	public void setStrokeWidth(int StrokeWidth) {
		this.StrokeWidth = StrokeWidth;
	}
	public void setVectorNode(int b) {
		this.vectorNode = b;
	}
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setDimension(Dimension d) {
		this.width = d.width;
		this.height = d.height;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getVectorNode() {
		return this.vectorNode;
	}
	public void setLinkPath() {
		LinkPath.reset();
		if(this.getWidth() < this.getHeight()) {
			this.setArcSize(this.getWidth()/5);
		}
		else {
			this.setArcSize(this.getHeight()/5);
		}
		//설정
		 if(vectorNode == 0) {
			//반비례 대각선 위에서 아래로
			/*
			 * --
			 * 	 |
			 *    --
			 */
			arc1 = new Arc2D.Double(x+this.getWidth()/2-ArcSize, y+StrokeWidth, ArcSize, ArcSize, 90, -90, Arc2D.OPEN);
			arc2 = new Arc2D.Double(x+this.getWidth()/2, y+this.getHeight()-ArcSize-StrokeWidth, ArcSize, ArcSize, 180, 90, Arc2D.OPEN);
			line1 = new Line2D.Double(x, y+StrokeWidth, x+this.getWidth()/2-ArcSize, y+StrokeWidth);
			line2 = new Line2D.Double(x+this.getWidth()/2+ArcSize, y+this.getHeight()-StrokeWidth, x+this.getWidth(), y+this.getHeight()-StrokeWidth);
		}
		else if(vectorNode == 1){
			//비례 대각선 위에서 아래로
			/*
			 * 	  |
			 * 	--
			 * |  
			 */
		
			arc1 = new Arc2D.Double(x+this.getWidth()-ArcSize-StrokeWidth ,y+this.getHeight()/2-ArcSize ,ArcSize, ArcSize, 0, -90, Arc2D.OPEN);
			arc2 = new Arc2D.Double(x+StrokeWidth ,y+this.getHeight()/2 ,ArcSize, ArcSize, 90, 90, Arc2D.OPEN);
			line1 = new Line2D.Double(x+this.getWidth()-StrokeWidth, y, x+this.getWidth()-StrokeWidth, y+this.getHeight()/2-ArcSize);
			line2 = new Line2D.Double(x+StrokeWidth, y+this.getHeight()/2+ArcSize, x+StrokeWidth, y+this.getHeight());
		}
		else if(vectorNode == 2) {
			//0 y축대칭
			arc1 = new Arc2D.Double(x+this.getWidth()/2-ArcSize, y+this.getHeight()-ArcSize-StrokeWidth, ArcSize, ArcSize, -90, 90, Arc2D.OPEN);
			arc2 = new Arc2D.Double(x+this.getWidth()/2, y+StrokeWidth, ArcSize, ArcSize, 180, -90, Arc2D.OPEN);
			line1 = new Line2D.Double(x, y+this.getHeight()-StrokeWidth, x+this.getWidth()/2-ArcSize, y+this.getHeight()-StrokeWidth);
			line2 = new Line2D.Double(x+this.getWidth()/2+ArcSize, y+StrokeWidth, x+this.getWidth(), y+StrokeWidth);
		}
		else if(vectorNode == 3) {
			//1 x축대칭
			arc1 = new Arc2D.Double(x+StrokeWidth ,y+this.getHeight()/2-ArcSize ,ArcSize, ArcSize, 180, 90, Arc2D.OPEN);
			arc2 = new Arc2D.Double(x+this.getWidth()-ArcSize-StrokeWidth ,y+this.getHeight()/2 ,ArcSize, ArcSize, 90, -90, Arc2D.OPEN);
			line1 = new Line2D.Double(x+StrokeWidth, y, x+StrokeWidth, y+this.getHeight()/2-ArcSize);
			line2 = new Line2D.Double(x+this.getWidth()-StrokeWidth, y+this.getHeight()/2+ArcSize, x+this.getWidth()-StrokeWidth, y+this.getHeight());
		}
		else if(vectorNode == 4) {
			lineM = new Line2D.Double(x, y, x+this.getWidth(), y);
		}
		else if(vectorNode == 5) {
			lineM = new Line2D.Double(x, y, x, y+this.getHeight());
		}
		//연결
		if( 0 <= vectorNode && vectorNode <=3) {
			LinkPath.append(line1, true);
			LinkPath.append(arc1, true);
			LinkPath.append(arc2, true);
			LinkPath.append(line2, true);
		}
		else if(vectorNode == 4	|| vectorNode == 5) {
			LinkPath.append(lineM, true);
		}
		else if(vectorNode == -1) {
			LinkPath.closePath();
		}
		
	}
	public Path2D getLine() {
		return LinkPath;
	}
	public Stroke getStroke() {
		return stroke;
	}
}