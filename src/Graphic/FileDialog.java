package Graphic;

import java.io.File;

import javax.swing.*;

import System.FileSystem;

public class FileDialog extends JFileChooser{
	
	public FileDialog() {
		
	}
	public void setOpen() {
		this.setDialogTitle("열기"); 
		this.setSelectedFile(new File("*.json"));
	}
	public void setSave() {
		this.setDialogTitle("저장"); 
		this.setSelectedFile(new File("untitled.json"));
	}
	public void setSaveNew() {
		this.setDialogTitle("다른이름으로 저장"); 
		this.setSelectedFile(new File("untitled.json"));
	}
	
}
