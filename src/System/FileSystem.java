package System;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import AttributeSystem.ShowAttribute;
import Graphic.FileDialog;
import MindMapSystem.makeShellMap;
import MindMapSystem.makeoutLines;
import TextEditorSystem.MakeTexttoTree;

public class FileSystem {
	
	public static JSONObject Save() {
		JSONObject saved = new JSONObject();
		
		saved.put("tree", MainSystem.toJson(MainSystem.getCurrentTree()));

		return saved;
	}
	
	public static void Open(FileReader file) {
		JSONParser parser = new JSONParser();

		try {
			Object selectObj = parser.parse(file);
			JSONObject jsonObj = (JSONObject)selectObj;
			MakeJsontoText.startMake(jsonObj);
			ShowAttribute.Deselected(MainSystem.getFrame().AP);
			MakeTexttoTree.startMake();
			makeShellMap.makeMap();
			makeoutLines.makeout(MainSystem.getCurrentTree());
			ShowAttribute.show(MainSystem.getFrame().AP, null);
			System.out.println(MainSystem.getCurrentTree().getTreeSize());
			MainSystem.getFrame().MMP.repaint();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} 
		catch (IOException e) { 
			e.printStackTrace();
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
