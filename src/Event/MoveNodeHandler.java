package Event;

import java.awt.Point;
import java.awt.event.*;

import javax.swing.JLabel;

import AttributeSystem.ShowAttribute;
import Graphic.MapNode;
import MindMapSystem.makeoutLines;
import System.MainSystem;

public class MoveNodeHandler extends MouseAdapter {
	
	private Point MMPxy;
	private int ComponentOnX;
	private int ComponentOnY;
	
	public MoveNodeHandler() {
		
	}
	
	public void mousePressed(MouseEvent e) {
		MMPxy = MainSystem.getFrame().MMP.getLocationOnScreen();
		ComponentOnX = e.getX();
		ComponentOnY = e.getY();
		
		MainSystem.getFrame().MMP.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		MapNode ClickedNode = (MapNode)e.getComponent();
		ShowAttribute.Selected(MainSystem.getFrame().AP, ClickedNode);
		
		Point ComponentXY = e.getLocationOnScreen();

		ClickedNode.setLocation(ComponentXY.x - MMPxy.x - ComponentOnX, ComponentXY.y - MMPxy.y - ComponentOnY);
		ClickedNode.setNodeXY(ComponentXY.x - MMPxy.x - ComponentOnX, ComponentXY.y - MMPxy.y - ComponentOnY);
		
		ShowAttribute.show(MainSystem.getFrame().AP, ClickedNode);
		
		ClickedNode.expressNode(MainSystem.getFrame().MMP);
		ClickedNode.getIncluded().refactorLink();
	}
	public void mouseReleased(MouseEvent e) {
		MapNode ClickedNode = (MapNode)e.getComponent();
		
		ClickedNode.setTransformable(true);
		
		ClickedNode.expressNode(MainSystem.getFrame().MMP);
		ClickedNode.getIncluded().refactorLink();
	}
}
