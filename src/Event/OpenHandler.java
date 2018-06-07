package Event;

import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.json.simple.JSONObject;

import System.FileSystem;
import System.MainSystem;

public class OpenHandler implements ActionListener {
	
	public OpenHandler() {	}
	
	public void actionPerformed(ActionEvent e) {
		int booleanSelected = MainSystem.getFrame().openDlog.showOpenDialog(MainSystem.getFrame());
		File selected = MainSystem.getFrame().openDlog.getSelectedFile();
		
		if(booleanSelected == JFileChooser.APPROVE_OPTION) {
			try{
				FileReader file = new FileReader(selected);
				FileSystem.Open(file);
			}
			catch (IOException err) {
				err.printStackTrace();
			}
		}
	}
}
