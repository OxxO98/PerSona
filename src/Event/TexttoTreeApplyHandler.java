package Event;

import Graphic.*;
import MindMapSystem.makeShellMap;
import System.*;
import TextEditorSystem.MakeTexttoTree;

import java.awt.event.*;

public class TexttoTreeApplyHandler implements ActionListener {
	
	private MainFrame mainFrame;
	
	public TexttoTreeApplyHandler(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void actionPerformed(ActionEvent e) {
		MakeTexttoTree.startMake(mainFrame.TEP);
		makeShellMap.makeMap(MainSystem.getCurrentTree(), mainFrame.MMP);
	}
}
