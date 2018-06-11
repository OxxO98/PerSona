package System;

import java.awt.Point;
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
	
	public static boolean saved = false;
	public static File savedFile;
	
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
			//트리 생성후
			MainSystem.getFrame().MMP.removeAll();
			MainSystem.getFrame().MMPScrollPane.getViewport().setViewPosition(new Point(0,0));
			MainSystem.getFrame().MMP.resizePane(MainSystem.getCurrentTree().getTreeSize());
			Point center = new Point(MainSystem.getFrame().MMP.getWidth()/2-MainSystem.getFrame().MMPScrollPane.getViewport().getWidth()/2
								,MainSystem.getFrame().MMP.getHeight()/2-MainSystem.getFrame().MMPScrollPane.getViewport().getHeight()/2);
			MainSystem.getFrame().MMPScrollPane.getViewport().setViewPosition(center);
			//MMP기초 설정후
			makeShellMap.makeMap(jsonObj);
			//Data설정후
			ShowAttribute.show(MainSystem.getFrame().AP, null);
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
