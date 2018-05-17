package Graphic;

import javax.swing.*;

public class ToolBar extends JToolBar{
	
	protected JButton save = new JButton("save");
	protected JButton open = new JButton("open");
	
	public ToolBar() {
		this.add(save);
		this.add(open);
		
		this.setVisible(true);
	}
}
