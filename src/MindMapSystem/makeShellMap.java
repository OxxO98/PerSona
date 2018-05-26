package MindMapSystem;

import System.*;
import Graphic.*;

public class makeShellMap {
	
	static Tree tree;
	static MindMapPane MMP;
	
	static public double ratio = 0.8;
	static public double distance = 120;
	static public double defWidth = 100, defHeight = 60;
	
	static private int midX, midY;
	
	public static void makeMap(Tree tree, MindMapPane MMP) {
		makeShellMap.tree = tree;
		makeShellMap.MMP = MMP;
		
		midX = MMP.getWidth()/2;
		midY = MMP.getHeight()/2;
		
		MMP.removeAll();
		makeShellMap.makeoutRoot();
		makeShellMap.makeoutNotRoot();
		
		MMP.repaint();
		MMP.setVisible(false);
		MMP.setVisible(true);
	}
	
	private static void makeoutNode(TreeNode node) {
		double Nratio = ratio;
		double Ndistance = distance;
		//Parent의 중앙점이 기준이다.
		double NcitX = (int)(node.getParent().getNodeX()+node.getParent().getWidth()/2);
		double NcitY = (int)(node.getParent().getNodeY()+node.getParent().getHeight()/2);
		for(int i = 0; i < node.getLevel()-1; i++) {
			Nratio *= ratio;
			Ndistance *= ratio;
		}
		double dX = (int)Ndistance, dY = (int)Ndistance;
		Ndistance = (int)Ndistance;
		double width = (int)defWidth*Nratio, height = (int)defHeight*Nratio;
		int NodeIndex = node.getThisLinkIndex();
		
		switch(NodeIndex) {
			case 0:
				dX *= 1;
				dY *= -1;
				break;
			case 1:
				dX *= 1;
				dY *= 1;
				break;
			case 2:
				dX *= -1;
				dY *= 1;
				break;
			case 3:
				dX *= -1;
				dY *= -1;
				break;
		}
		node.setDimension(width, height);
		node.setXY(NcitX+dX-width/2, NcitY+dY-height/2);
		node.expressNode(MMP);
		node.showMember(MMP);
	}
	
	private static void makeoutNotRoot() {
		TreeNode node = makeShellMap.tree.root.getChild();
		if(node == null) {
			return;
		}
		while(true) {
			makeShellMap.makeoutNode(node);
			if(tree.goNext(node) == null) {
				break;
			}
			node = tree.goNext(node);
		}
		
	}
	
	private static void makeoutRoot() {
		tree.root.setDimension(defWidth, defHeight);
		tree.root.setXY(midX-defWidth/2, midY-defHeight/2);
		tree.root.expressNode(MMP);
		tree.root.showMember(MMP);
	}
}