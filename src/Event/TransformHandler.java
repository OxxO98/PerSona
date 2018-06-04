package Event;

import java.awt.Point;
import java.awt.event.*;

import javax.swing.JLabel;

import AttributeSystem.ShowAttribute;
import Graphic.MapNode;
import Graphic.TransformPoint;
import System.MainSystem;

public class TransformHandler extends MouseAdapter {
	
	private Point MMPxy;
	private int ComponentOnX;
	private int ComponentOnY;
	
	public TransformHandler() {	}
	
	public void mousePressed(MouseEvent e) {
		MMPxy = MainSystem.getFrame().MMP.getLocationOnScreen();
		ComponentOnX = e.getX();
		ComponentOnY = e.getY();
		
		TransformPoint ClickPoint = (TransformPoint)e.getComponent();
		
		System.out.println(ClickPoint);
	}
	public void mouseDragged(MouseEvent e) {
		TransformPoint ClickedPoint = (TransformPoint)e.getComponent();
		MapNode ClickedNode = MainSystem.getFrame().AP.SelectedNode;
				
		Point ComponentXY = e.getLocationOnScreen();
		
		ClickedPoint.setLocation(ComponentXY.x - MMPxy.x - ComponentOnX, ComponentXY.y - MMPxy.y - ComponentOnY);
		ClickedPoint.setXY(ComponentXY.x - MMPxy.x - ComponentOnX, ComponentXY.y - MMPxy.y - ComponentOnY);
		
		ClickedNode.expressNode(MainSystem.getFrame().MMP);
		
		MainSystem.getFrame().MMP.repaint();
	}
	public void mouseReleased(MouseEvent e) {
		MapNode ClickedNode = MainSystem.getFrame().AP.SelectedNode;
		TransformPoint ClickedPoint = (TransformPoint)e.getComponent();
		
		ClickedNode.alignTransform(ClickedPoint.getAttribute());
	}
	
}
