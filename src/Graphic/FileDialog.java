package Graphic;

import java.io.File;

import javax.swing.*;

public class FileDialog extends JFileChooser{
	
	public FileDialog() {
		this.setDialogTitle("���� �����ϱ�"); 
		this.setSelectedFile(new File("untitled.json"));
	}
	
}
