package Event;

import Graphic.*;
import System.*;

import java.awt.event.*;

import javax.swing.JLabel;

import AttributeSystem.ShowAttribute;

public class ShowAttributeHandler extends MouseAdapter{
	
	public ShowAttributeHandler() {
	}
	
	public void mousePressed(MouseEvent e) {
		JLabel ClickedNode = (JLabel)e.getComponent();
		if(ClickedNode != MainSystem.getFrame().AP.SelectedNode) {
			ShowAttribute.Selected(MainSystem.getFrame().AP, (MapNode)ClickedNode);
		}
		else {
			ShowAttribute.Deselected(MainSystem.getFrame().AP);
		}
		//out

		ShowAttribute.show(MainSystem.getFrame().AP, MainSystem.getFrame().AP.SelectedNode);
	}
}
