package Graphic;

import javax.swing.*;

import MindMapSystem.makeoutLines;
import System.MainSystem;
import System.Tree;
import System.TreeNode;

import java.awt.*;

public class MindMapPane extends JPanel {
	
	private MainFrame mainFrame;
	private JScrollPane ScrollPane = new JScrollPane();
	
	public MindMapPane(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		this.setBackground(new Color(0xFFFFFF));
		this.setLayout(null);
		
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D vector = (Graphics2D)g;
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Tree tree = MainSystem.getCurrentTree();
		
		super.paintComponent(g);
		
		if(tree == null) {
			System.out.println("null");
			return;
		}
		TreeNode node = tree.root.getChild();
		if(node == null) {
			return;
		}
		while(true) {
			int index = makeoutLines.filterLine(node);
			System.out.println(index);
			if(index != -1) {
				node.Map.criteria[index].expressLine();
				vector.setStroke(node.Map.criteria[index].Line.getStroke());
				vector.draw(node.Map.criteria[index].Line.getLine());
			}
			if(tree.goNext(node) == null) {
				break;
			}
			node = tree.goNext(node);
		}
	}
	
	//¸Þ¼Òµå
	public void resizePane(Dimension d) {
		MainSystem.getFrame().MMPScrollPane.getViewport().getView().setPreferredSize(d);
		MainSystem.getFrame().MMP.setSize(d);
	}
}
