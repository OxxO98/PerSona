package Graphic;

import java.io.File;

import javax.swing.*;

import System.FileSystem;

public class FileDialog extends JFileChooser{
	
	public FileDialog() {
		
	}
	public void setOpen() {
		this.setDialogTitle("����"); 
		this.setSelectedFile(new File("*.json"));
	}
	public void setSave() {
		this.setDialogTitle("����"); 
		this.setSelectedFile(new File("untitled.json"));
	}
	public void setSaveNew() {
		this.setDialogTitle("�ٸ��̸����� ����"); 
		this.setSelectedFile(new File("untitled.json"));
	}
	
}
