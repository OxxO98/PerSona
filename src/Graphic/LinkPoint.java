package Graphic;

public class LinkPoint {
	private double x, y;
	private boolean link;
	
	public LinkPoint linkedPoint = null;
	public MapNode includedNode = null;
	//������
	public LinkPoint(double x, double y){
		this.x = x;
		this.y = y;
		this.link = false;
	}
	//�޼ҵ�
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
}
