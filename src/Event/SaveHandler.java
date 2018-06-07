package Event;

import java.awt.event.*;
import java.io.*;

import javax.swing.JFileChooser;

import org.json.simple.JSONObject;

import Graphic.*;
import System.*;

public class SaveHandler implements ActionListener {
	
	public SaveHandler() {	}
	
	public void actionPerformed(ActionEvent e) {
		int booleanSelected = MainSystem.getFrame().saveDlog.showSaveDialog(MainSystem.getFrame());
		File selected = MainSystem.getFrame().saveDlog.getSelectedFile();
		JSONObject savedData = FileSystem.Save();
		
		if(booleanSelected == JFileChooser.APPROVE_OPTION) {
			try{
				FileWriter file = new FileWriter(selected);
				file.write(savedData.toJSONString());
				file.flush();
				file.close();
			}
			catch (IOException err) {
				err.printStackTrace();
			}
		}
	}
}
