package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MapNode extends JLabel{
	//criteria Point
	protected LinkPoint [] criteria = new LinkPoint[4];
	//Color
	private Color ForeGroundColor = new Color(0xFFFFFF);
	private Color BackGroundColor = new Color(0x303030);
	//data & Location
	private double x, y, width, height;
	protected String data;
	//Graphics
	private Graphics2D vector;
	private int strokeWidth = 5;
	//생성자
	public MapNode() {
		this.setDimension(100,100);
		this.setXY(0, 0);
		this.setCriteria();
	}
	//express
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.vector = (Graphics2D)g;
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.drawNode(vector);
	}
	public void expressNode(MindMapPane MMP) {
		//graphic처리 부분
		this.setLocation((int)x, (int)y);
		this.setSize(new Dimension((int)width, (int)height));
		this.setVisible(true);
		//MMP에 추가
		MMP.add(this);
		//this.repaint();
	}
	public void showMember(MindMapPane MMP) {
		System.out.println(x + " " + y + " " + width + " " + height);
		System.out.println(MMP.getWidth() +  " " + MMP.getHeight());
	}
	//get Method
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
	//set Method
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void setDimension(double width, double height) {
		this.width = width;
		this.height = height;
	}
	public void setColor() {
		this.setForeground(this.ForeGroundColor);
		this.setBackground(this.BackGroundColor);
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return data;
	}
	//
	//private 메소드
	//Graphics
	private void drawNode(Graphics2D vector) {
		RoundRectangle2D rect = new RoundRectangle2D.Double(strokeWidth, strokeWidth, width-strokeWidth*2, height-strokeWidth*2, width/5, height/5);
		Stroke stroke = new BasicStroke(strokeWidth);
		vector.setStroke(stroke);
		vector.draw(rect);
		vector.setPaint(ForeGroundColor);
		vector.fill(rect);
	}
	//link
	protected boolean hasLink(int index) {
		return this.criteria[index].getLink();
	}
	//Attribute
	private void setCriteria() {
		/*
		 * 각도순으로	0	1	2	3
		 * 			0	90	180	270
		 */
		this.criteria[0] = new LinkPoint(x + width/2, y);
		this.criteria[1] = new LinkPoint(x + width, y + height/2);
		this.criteria[2] = new LinkPoint(x + width/2, y + height);
		this.criteria[3] = new LinkPoint(x, y + height/2);
		
		for(int i = 0; i < 4; i++) {
			this.criteria[i].includedNode = this;
		}
	}
	
}
