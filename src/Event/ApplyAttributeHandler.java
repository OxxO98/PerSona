package Event;

import java.awt.event.*;
import AttributeSystem.*;
import Graphic.*;
import System.*;

public class ApplyAttributeHandler implements ActionListener {
	
	public ApplyAttributeHandler() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(MainSystem.getFrame().AP.SelectedNode == null) {
			return;
		}
		MapNode node = MainSystem.getFrame().AP.SelectedNode;
		ShowAttribute.Deselected(MainSystem.getFrame().AP);		//null	node
		ShowAttribute.Apply(MainSystem.getFrame().AP, node);	//null	node
		ShowAttribute.Selected(MainSystem.getFrame().AP, node);	//node 	node
		ShowAttribute.show(MainSystem.getFrame().AP, node);
		
		MainSystem.getFrame().MMP.repaint();
	}
}
