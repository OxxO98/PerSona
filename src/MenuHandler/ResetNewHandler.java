package MenuHandler;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;

import System.ColorSet;
import System.FileSystem;
import System.MainSystem;
import System.Tree;

public class ResetNewHandler implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		MainSystem.getFrame().TEP.setText("");
		MainSystem.removeTree();
		MainSystem.setTree(new Tree());
		MainSystem.getFrame().MMP.removeAll();
		MainSystem.getFrame().MMP.resizePane(MainSystem.defaultMMPSize);
		MainSystem.getFrame().MMP.repaint();
		
		FileSystem.saved = false;
		FileSystem.savedFile = null;
	}
}
