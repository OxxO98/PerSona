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
		MakeTexttoTree.startMake();	
		
		MainSystem.getFrame().MMP.setPreferredSize(MainSystem.getCurrentTree().getTreeSize());
		
		makeShellMap.makeMap(MainSystem.getCurrentTree(), MainSystem.getFrame().MMP);
		makeoutLines.makeout(MainSystem.getCurrentTree());
		
		ShowAttribute.show(MainSystem.getFrame().AP, null);
		
		MainSystem.getFrame().MMP.repaint();
	}
}
