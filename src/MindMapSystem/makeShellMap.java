package MindMapSystem;

import System.*;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Event.ShowAttributeHandler;
import Graphic.*;

public class makeShellMap {
	
	static public double ratioDistance = 0.5;
	static public double ratioSize = 0.7;
	static public double distance = 250;
	static public double defWidth = 120, defHeight = 80;
	
	static private int midX, midY;
	
	public static void makeMap() {
		Tree tree = MainSystem.getCurrentTree();
		MindMapPane MMP = MainSystem.getFrame().MMP;
		
		midX = MMP.getWidth()/2;
		midY = MMP.getHeight()/2;
		
		makeShellMap.makeoutRoot();
		makeShellMap.makeoutNotRoot();
		
		MMP.repaint();
		MMP.setVisible(false);
		MMP.setVisible(true);
	}
	public static void makeMap(JSONObject jsonObj) {
		Tree tree = MainSystem.getCurrentTree();
		MindMapPane MMP = MainSystem.getFrame().MMP;
		
		JSONArray treeArray = (JSONArray)jsonObj.get("tree");
		
		TreeNode selectedNode = tree.root;
		
		int i = 0;
		while(true) {
			makeShellMap.setData(selectedNode, (JSONObject)treeArray.get(i));
			if(tree.goNext(selectedNode) == null) {
				break;
			}
			selectedNode = tree.goNext(selectedNode);
			i++;
		}
		
		makeShellMap.expressMap(tree);
		
		MMP.repaint();
		MMP.setVisible(false);
		MMP.setVisible(true);
	}
	public static void expressMap(Tree tree) {
		MindMapPane MMP = MainSystem.getFrame().MMP;

		TreeNode selectedNode = tree.root;
		
		while(true) {
			selectedNode.Map.expressNode(MMP);
			if(tree.goNext(selectedNode) == null) {
				break;
			}
			selectedNode = tree.goNext(selectedNode);
		}
		
		MMP.repaint();
		MMP.setVisible(false);
		MMP.setVisible(true);
	}
	private static void setData(TreeNode node, JSONObject jsonObj) {
		JSONObject MapData = (JSONObject)jsonObj.get("Map");
		
		node.Map.setData((String)MapData.get("data"));
		node.Map.setNodeX(	(double)MapData.get("x"));
		node.Map.setNodeY(	(double)MapData.get("y"));
		node.Map.setNodeWidth(	(double)MapData.get("width"));
		node.Map.setNodeHeight(	(double)MapData.get("height"));
		
		node.Map.setColor(	(Color)MainSystem.toColor((String)MapData.get("ForeGroundColor"))
							,(Color)MainSystem.toColor((String)MapData.get("BackgroundColor")));
		node.Map.setStrokeWidth(((Long)MapData.get("strokeWidth")).intValue());
		
		node.Map.setDimension(node.Map.getNodeWidth(), node.Map.getNodeHeight());
		node.Map.setNodeXY(node.Map.getNodeX(), node.Map.getNodeY());
	}
	private static void makeoutNode(TreeNode node) {
		MindMapPane MMP = MainSystem.getFrame().MMP;
		
		double Nratio = ratioSize;
		double Ndistance = distance;
		//Parent의 중앙점이 기준이다.
		double NcitX = (int)(node.getParent().Map.getNodeX()+node.getParent().Map.getWidth()/2);
		double NcitY = (int)(node.getParent().Map.getNodeY()+node.getParent().Map.getHeight()/2);
		for(int i = 0; i < node.getLevel()-1; i++) {
			Nratio *= ratioSize;
			Ndistance *= ratioDistance;
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
		node.Map.setDimension(width, height);
		node.Map.setNodeXY(NcitX+dX-width/2, NcitY+dY-height/2);
	}
	
	private static void makeoutNotRoot() {
		Tree tree = MainSystem.getCurrentTree();
		MindMapPane MMP = MainSystem.getFrame().MMP;
		
		TreeNode node = tree.root.getChild();
		if(node == null) {
			return;
		}
		while(true) {
			makeShellMap.makeoutNode(node);
			node.Map.expressNode(MMP);
			if(tree.goNext(node) == null) {
				break;
			}
			node = tree.goNext(node);
		}
		
	}
	
	private static void makeoutRoot() {
		Tree tree = MainSystem.getCurrentTree();
		MindMapPane MMP = MainSystem.getFrame().MMP;
		
		tree.root.Map.setDimension(defWidth, defHeight);
		tree.root.Map.setNodeXY(midX-defWidth/2, midY-defHeight/2);
		tree.root.Map.expressNode(MMP);
//		tree.root.Map.showMember(MMP);
	}
}