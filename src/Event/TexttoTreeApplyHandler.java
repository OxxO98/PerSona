package Event;

import Graphic.*;
import MindMapSystem.makeShellMap;
import MindMapSystem.makeoutLines;
import System.*;
import TextEditorSystem.MakeTexttoTree;

import java.awt.event.*;

import AttributeSystem.ShowAttribute;

public class TexttoTreeApplyHandler implements ActionListener {
	
	public TexttoTreeApplyHandler() {
	}
	
	public void actionPerformed(ActionEvent e) {
		ShowAttribute.Deselected(MainSystem.getFrame().AP);
		MakeTexttoTree.startMake();
		makeShellMap.makeMap(MainSystem.getCurrentTree(), MainSystem.getFrame().MMP);
		makeoutLines.makeout(MainSystem.getCurrentTree());
		ShowAttribute.show(MainSystem.getFrame().AP, null);
	}
}
