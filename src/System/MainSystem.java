package System;

import java.awt.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Graphic.MainFrame;
import Graphic.MapNode;
import Graphic.TransformPoint;

public class MainSystem implements TreeSystem{
	private static MainFrame mainProgram;
	
	public static Dimension defaultMMPSize = new Dimension(800, 600);
	
	static Tree [] tree = new Tree[1];
	static int currentIndex = 0;
	
	//mainFrameSystem
	public static void start() {
		mainProgram = new MainFrame();
	}
	public static MainFrame getFrame() {
		return mainProgram;
	}
	
	//TreeSystem
	public void addTree(Tree tree) {
		Tree [] savedTree = new Tree[MainSystem.tree.length+1];
		for(int i = 0; i < MainSystem.tree.length; i++) {
			savedTree[i] = MainSystem.tree[i];
		}
		MainSystem.tree = savedTree;
	}
	public Tree getTree(int treeIndex) {
		return MainSystem.tree[treeIndex];
	}
	public static void setTree(Tree tree) {
		MainSystem.tree[MainSystem.currentIndex] = tree;
	}
	public static Tree getCurrentTree() {
		return MainSystem.tree[MainSystem.currentIndex];
	}
	
	//AttributeSystem
	public static String toString(int i) {
		return "" + i;
	}
	public static String toString(double d) {
		return "" + d;
	}
	public static String toString(Color color) {
		int Red = color.getRed();
		int Green = color.getGreen();
		int Blue = color.getBlue();
//		int Alpha = color.getAlpha();
		
		String str1 = String.format("%02X", Red);
		String str2 = String.format("%02X", Green);
		String str3 = String.format("%02X", Blue);
//		String str4 = String.format("%02X", Alpha);
		
		return str1 + str2 + str3;
	}
	public static Color toColor(String str) {
//		String str4 = str.substring(0, 1);
		String str3 = str.substring(0, 2);
		String str2 = str.substring(2, 4);
		String str1 = str.substring(4);
		
		int [] colorInteger = new int[4];
		colorInteger[0] = Integer.parseInt(str3, 16);	//r
		colorInteger[1] = Integer.parseInt(str2, 16);	//g
		colorInteger[2] = Integer.parseInt(str1, 16);	//b
//		colorInteger[3] = Integer.parseInt(str4, 16);
		
		//alpha가 있는가
		Color returnColor = new Color(colorInteger[0], colorInteger[1], colorInteger[2]);
		
//		System.out.println(colorInteger[0] + " " + colorInteger[1] + " " + colorInteger[2]);
		
		return returnColor;
	}
	//toJSONObject
	public static JSONArray toJson(Tree tree) {
		JSONArray returnJson = new JSONArray();
		
		TreeNode selectedNode = tree.root;
		int i = 0;
		while(true) {
			returnJson.add(i, MainSystem.toJson(selectedNode));
			if(tree.goNext(selectedNode) == null) {
				break;
			}
			i++;
			selectedNode = tree.goNext(selectedNode);
		}
		
		return returnJson;
	}
	public static JSONObject toJson(TreeNode node) {
		JSONObject returnJson = new JSONObject();
		
		returnJson.put("level", node.getLevel());
		returnJson.put("Map", MainSystem.toJson(node.Map));
		
		return returnJson;
	}
	public static JSONObject toJson(MapNode node) {
		JSONObject returnJson = new JSONObject();
		
		returnJson.put("data", node.getData());
		returnJson.put("x", node.getNodeX());
		returnJson.put("y", node.getNodeY());
		returnJson.put("width", node.getNodeWidth());
		returnJson.put("height", node.getNodeHeight());
		
//		returnJson.put("ForeGroundColor", node.getForeground());
//		returnJson.put("BackgroundColor", node.getBackground());
		returnJson.put("strokeWidth", node.getStrokeWidth());
		
		return returnJson;
	}
}
