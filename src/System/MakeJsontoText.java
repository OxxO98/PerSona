package System;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Graphic.*;
import TextEditorSystem.MakeTexttoTree;

public class MakeJsontoText {
	
	static Tree tree;
	
	//public¸Þ¼Òµå
	public static void startMake(JSONObject jsonObj) {
		TextEditorPane TEP = MainSystem.getFrame().TEP;
		
		JSONArray treeArray = (JSONArray)jsonObj.get("tree");
		String [] returnStr = new String[treeArray.size()];
		
		for(int i = 0; i < treeArray.size(); i++) {
			returnStr[i] = MakeJsontoText.makeTextNode((JSONObject)treeArray.get(i));
		}
		
		String str = new String();
		for(int i = 0; i < returnStr.length; i++) {
			str += returnStr[i];
			str += "\n";
		}
		
		TEP.setText(str);
	}
	//private
	private static String makeTextNode(JSONObject jsonObj) {
		String levelStr;
		String dataStr;
		String str;
		
		Long level = (Long)jsonObj.get("level");
		dataStr = (String)((JSONObject)jsonObj.get("Map")).get("data");
		str = dataStr;
		
		if(level != 0) {
			levelStr = MakeJsontoText.makeTextLevel(level);
			str = levelStr + dataStr;
		}
		
		return str;
	}
	private static String makeTextLevel(long level) {
		String str = new String();
		for(int i = 0; i < level; i++) {
			str += "\t";
		}
		
		return str;
	}
}
