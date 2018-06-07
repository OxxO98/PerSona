package Event;

import java.awt.event.*;

import AttributeSystem.ShowAttribute;
import MindMapSystem.makeShellMap;
import MindMapSystem.makeoutLines;
import System.MainSystem;

public class WindowStateHandler extends ComponentAdapter {

	
//	WINDOW_STATE_CHANGED
	public WindowStateHandler() {	}
	
	public void componentResized(ComponentEvent e) {
		try {
			MainSystem.getFrame().rightSplitPane.setDividerLocation((int)e.getComponent().getSize().getWidth()*3/4);
			MainSystem.getFrame().leftSplitPane.setDividerLocation((int)e.getComponent().getSize().getWidth()*1/4);
			
		}
		catch(NullPointerException err) {	}
	}
}
