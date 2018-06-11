package Event;

import Graphic.*;
import MindMapSystem.makeShellMap;
import MindMapSystem.makeoutLines;
import System.*;
import TextEditorSystem.MakeTexttoTree;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.Border;

import AttributeSystem.ShowAttribute;

public class TexttoTreeApplyHandler implements ActionListener {
	
	public TexttoTreeApplyHandler() {	}
	
	public void actionPerformed(ActionEvent e) {	
		ShowAttribute.Deselected(MainSystem.getFrame().AP);
		
		MainSystem.getFrame().MMPScrollPane.getViewport().setViewPosition(new Point(0,0));
		
		boolean well = MakeTexttoTree.startMake();
		MainSystem.getFrame().MMP.removeAll();
		
		if(well == false) {
			MainSystem.getFrame().MMP.resizePane(MainSystem.defaultMMPSize);
			return;
		}
		MainSystem.getFrame().MMP.resizePane(MainSystem.getCurrentTree().getTreeSize());
		
		Point center = new Point(MainSystem.getFrame().MMP.getWidth()/2-MainSystem.getFrame().MMPScrollPane.getViewport().getWidth()/2
								,MainSystem.getFrame().MMP.getHeight()/2-MainSystem.getFrame().MMPScrollPane.getViewport().getHeight()/2);
		MainSystem.getFrame().MMPScrollPane.getViewport().setViewPosition(center);
		
		makeShellMap.makeMap();
		
		ShowAttribute.show(MainSystem.getFrame().AP, null);
		
		MainSystem.getFrame().MMP.repaint();
	}
}
