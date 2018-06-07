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
	
	int atr;
	int Px, Py;
	
	public TransformHandler() {	}
	
	public void mousePressed(MouseEvent e) {
		MMPxy = MainSystem.getFrame().MMP.getLocationOnScreen();
		ComponentOnX = e.getX();
		ComponentOnY = e.getY();
		
		TransformPoint ClickedPoint = (TransformPoint)e.getComponent();
		
		Px = ClickedPoint.getNodeX();
		Py = ClickedPoint.getNodeY();
	}
	public void mouseDragged(MouseEvent e) {
		TransformPoint ClickedPoint = (TransformPoint)e.getComponent();
		MapNode ClickedNode = MainSystem.getFrame().AP.SelectedNode;
		
		Point ComponentXY = e.getLocationOnScreen();
		atr = ClickedPoint.getAttribute();
		
		
		System.out.println(atr);
		
		if(atr == 0 || atr == 4) {
			ClickedPoint.setLocation(Px, ComponentXY.y - MMPxy.y - ComponentOnY);
			ClickedPoint.setNodeY(ComponentXY.y - MMPxy.y - ComponentOnY);
		}
		else if(atr == 2 || atr == 6) {
			ClickedPoint.setLocation(ComponentXY.x - MMPxy.x - ComponentOnX, Py);
			ClickedPoint.setNodeX(ComponentXY.x - MMPxy.x - ComponentOnX);
		}
		else {
			ClickedPoint.setLocation(ComponentXY.x - MMPxy.x - ComponentOnX, ComponentXY.y - MMPxy.y - ComponentOnY);
			ClickedPoint.setNodeX(ComponentXY.x - MMPxy.x - ComponentOnX);
			ClickedPoint.setNodeY(ComponentXY.y - MMPxy.y - ComponentOnY);
		}
		
		ClickedNode.alignTransform(atr);	//MapNode�� xywh�� ����
		ClickedNode.expressTransformPoint(atr);	//TransformPoint���̱�
		
		ClickedNode.expressNode(MainSystem.getFrame().MMP);	//������ ������ MapNode Express
		ShowAttribute.show(MainSystem.getFrame().AP, ClickedNode);	//����ǥ��
		
		ClickedNode.getIncluded().refactorLink();	//������ �缳��
		
		MainSystem.getFrame().MMP.repaint();	//�ٽñ׸���
	}
	public void mouseReleased(MouseEvent e) {
		MapNode ClickedNode = MainSystem.getFrame().AP.SelectedNode;
		TransformPoint ClickedPoint = (TransformPoint)e.getComponent();
		//����ȭ
		ClickedNode.setTransformable(true);
		
		MainSystem.getFrame().MMP.repaint();
	}
	
}
