package Event;

import Graphic.*;
import System.*;

import java.awt.event.*;

public class ShowAttributeHandler implements ActionListener {
	
	private MainFrame mainFrame;
	
	public ShowAttributeHandler(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void actionPerformed(ActionEvent e) {
		MapNode ClickedNode = (MapNode)e.getSource();
	}
	
}
