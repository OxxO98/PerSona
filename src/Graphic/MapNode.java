package Graphic;

import javax.swing.*;

import Event.MoveNodeHandler;
import Event.ShowAttributeHandler;
import Event.TransformHandler;
import MindMapSystem.makeoutLines;
import System.MainSystem;
import System.TreeNode;

import java.awt.*;
import java.awt.geom.*;

public class MapNode extends JLabel{
	
	//TransformPoint
	public TransformPoint [] transform = new TransformPoint[8];
	public CenterPoint center = new CenterPoint();
	
	//criteria Point
	public LinkPoint [] criteria = new LinkPoint[4];
	
	//Color
	private Color ForeGroundColor = new Color(0x000000);
	private Color BackGroundColor = new Color(0xFFFFFF);
	
	//data & Location
	private double x, y, width, height;
	private String data;
	private TreeNode included;
	
	//Graphics
	private Graphics2D vector;
	private int strokeWidth = 5;
	private boolean init = false;
	
	//생성자
	public MapNode() {
		this.setDimension(100,100);
		this.setNodeXY(0, 0);
		this.setCriteriaDefault();
	}
	
	//express
	public void paintComponent(Graphics g) {
		this.vector = (Graphics2D)g;
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.drawNode(vector);
		super.paintComponent(g);
	}
	public void expressNode(MindMapPane MMP) {
		//graphic처리 부분
		this.setLocation((int)x, (int)y);
		this.setSize((int)width, (int)height);
		this.setVisible(true);
		this.setCriteria();
		//MMP에 추가
		this.setHorizontalAlignment(CENTER);
		this.setText(data);
		//transformPoint관련
		if(this.init == false) {
			MMP.add(this);
			this.setTransformPoint();
			this.addMouseListener(new ShowAttributeHandler());
			MoveNodeHandler initMoveNodeHandler = new MoveNodeHandler();
			this.addMouseMotionListener(initMoveNodeHandler);
			this.addMouseListener(initMoveNodeHandler);
			init = true;
		}
	}
	public void setTransformable(boolean b) {
		if(b == true) {
			for(int i = 0; i < 8; i++) {
				this.transform[i].resetTransform(i, (int)x, (int)y, (int)width, (int)height);
				this.transform[i].express();
				this.transform[i].setVisible(true);
			}
		}
		else {
			for(int i = 0; i < 8; i++) {
				this.transform[i].setVisible(false);
			}
		}
	}
	public void setTransformable(int atr, boolean b) {
		if(b == true) {
			for(int i = 0; i < 8; i++) {
				if(atr == i) {	continue;	}
				this.transform[i].resetTransform(i, (int)x, (int)y, (int)width, (int)height);
				this.transform[i].express();
				this.transform[i].setVisible(true);
			}
		}
		else {
			for(int i = 0; i < 8; i++) {
				if(atr == i) {	continue;	}
				this.transform[i].setVisible(false);
			}
		}
	}
	private void setTransformPoint() {
		for(int i = 0; i < 8; i++) {
			this.transform[i] = new TransformPoint(i, (int)x, (int)y, (int)width, (int)height);
		}
	}
	public void alignTransform(int atr) {
		int pointSize = transform[0].getPointSize()/2;
		
		int minX = transform[7].getNodeX() + pointSize;
		int minY = transform[7].getNodeY() + pointSize;
		int maxX = transform[3].getNodeX();
		int maxY = transform[3].getNodeY();
		
		switch(atr) {
			case 0 :
				minY = transform[0].getNodeY() + pointSize;
				break;
			case 1 :
				maxX = transform[1].getNodeX();
				minY = transform[1].getNodeY() + pointSize;
				break;
			case 2 :
				maxX = transform[2].getNodeX();
				break;
			case 3 :
				maxX = transform[3].getNodeX();
				maxY = transform[3].getNodeY();
				break;
			case 4 :
				maxY = transform[4].getNodeY();
				break;
			case 5 :
				minX = transform[5].getNodeX() + pointSize;
				maxY = transform[5].getNodeY();
				break;
			case 6 :
				minX = transform[6].getNodeX() + pointSize;
				break;
			case 7 :
				minX = transform[7].getNodeX() + pointSize;
				minY = transform[7].getNodeY() + pointSize;
				break;
		}
		
		System.out.println(minX + " " + maxX);
		System.out.println(minY + " " + maxY);
		
		this.x = minX;
		this.y = minY;
		this.width = maxX - minX;
		this.height = maxY - minY;
	}
	//Draw
	private void drawNode(Graphics2D vector) {
		RoundRectangle2D rect = new RoundRectangle2D.Double(strokeWidth, strokeWidth, width-strokeWidth*2, height-strokeWidth*2, width/5, height/5);
		Stroke stroke = new BasicStroke(strokeWidth);
		vector.setStroke(stroke);
		vector.setColor(ForeGroundColor);
		vector.draw(rect);
		vector.setPaint(BackGroundColor);
		vector.fill(rect);
	}
	
	//get Method
	public TreeNode getIncluded() {
		return this.included;
	}
	public double getNodeX() {
		return this.x;
	}
	public double getNodeY() {
		return this.y;
	}
	public double getNodeWidth() {
		return this.width;
	}
	public double getNodeHeight() {
		return this.height;
	}
	public Color getNodeColor() {
		return this.BackGroundColor;
	}
	public int getStrokeWidth() {
		return this.strokeWidth;
	}
	
	//set Method
	public void setInclude(TreeNode node) {
		this.included = node;
	}
	public void setNodeXY(double x, double y) {
		this.x = (int)x;
		this.y = (int)y;
	}
	public void setDimension(double width, double height) {
		this.width = (int)width;
		this.height = (int)height;
	}
	public void setNodeX(double x) {
		this.x = (int)x;
	}
	public void setNodeY(double y) {
		this.y = (int)y;
	}
	public void setNodeWidth(double width) {
		this.width = (int)width;
	}
	public void setNodeHeight(double height) {
		this.height = (int)height;
	}
	public void setColor() {
		this.ForeGroundColor = new Color(0x000000);
		this.BackGroundColor = new Color(0xFFFFFF);
	}
	public void setColor(Color Back) {
		this.BackGroundColor = Back;
	}
	public void setColor(Color Fore, Color Back) {
		this.ForeGroundColor = Fore;
		this.BackGroundColor = Back;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return data;
	}
	
	//link
	public boolean hasLink(int index) {
		return this.criteria[index].getLink();
	}
	private void setCriteriaDefault() {
		/*
		 * 각도순으로		0
		 * 			3		1
		 * 				2
		 */
		this.criteria[0] = new LinkPoint(x + width/2, y);
		this.criteria[1] = new LinkPoint(x + width, y + height/2);
		this.criteria[2] = new LinkPoint(x + width/2, y + height);
		this.criteria[3] = new LinkPoint(x, y + height/2);
		
		for(int i = 0; i < 4; i++) {
			this.criteria[i].includedNode = this;
		}
	}
	private void setCriteria() {
		this.criteria[0].setXY(x + width/2, y);
		this.criteria[1].setXY(x + width, y + height/2);
		this.criteria[2].setXY(x + width/2, y + height);
		this.criteria[3].setXY(x, y + height/2);
	}
	//Debug
	public void showMember(MindMapPane MMP) {
		System.out.println(x + " " + y + " " + width + " " + height);
		System.out.println(MMP.getWidth() +  " " + MMP.getHeight());
	}
}
