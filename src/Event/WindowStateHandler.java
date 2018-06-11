package Event;

import java.awt.Point;
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
			MainSystem.getFrame().rightSplitPane.setDividerLocation((int)MainSystem.getFrame().getSize().getWidth()*3/4);
			MainSystem.getFrame().leftSplitPane.setDividerLocation((int)MainSystem.getFrame().getSize().getWidth()/4);
			
			Point center = new Point(MainSystem.getFrame().MMP.getWidth()/2-MainSystem.getFrame().MMPScrollPane.getViewport().getWidth()/2
					,MainSystem.getFrame().MMP.getHeight()/2-MainSystem.getFrame().MMPScrollPane.getViewport().getHeight()/2);
			MainSystem.getFrame().MMPScrollPane.getViewport().setViewPosition(center);
			
			
		}
		catch(NullPointerException err) {	}
	}
}
