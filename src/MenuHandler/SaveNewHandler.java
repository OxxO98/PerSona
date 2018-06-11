package MenuHandler;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.json.simple.JSONObject;

import System.FileSystem;
import System.MainSystem;
import java.awt.event.*;

public class SaveNewHandler implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		int booleanSelected = MainSystem.getFrame().saveDlog.showSaveDialog(MainSystem.getFrame());
		if(booleanSelected == JFileChooser.CANCEL_OPTION) {
			return;
		}
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
		FileSystem.savedFile = selected;
		FileSystem.saved = true;
	}
}
