package Graphic;

import java.io.File;

import javax.swing.*;

public class FileDialog extends JFileChooser{
	
	public FileDialog() {
		this.setDialogTitle("파일 저장하기"); 
		this.setSelectedFile(new File("untitled.json"));
	}
	
}
