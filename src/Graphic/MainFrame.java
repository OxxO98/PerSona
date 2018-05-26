package Graphic;

import Graphic.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	protected MenuBar menu = new MenuBar();
	protected ToolBar tool = new ToolBar();
	
	protected JPanel mainPane = new JPanel();
	protected JSplitPane rightSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	protected JSplitPane leftSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	public AttributePane AP = new AttributePane(this);
	public TextEditorPane TEP = new TextEditorPane(this);
	public MindMapPane MMP = new MindMapPane(this);
	
	public MainFrame() {		
		setTitle("MindMap Program");
		setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		this.setJMenuBar(menu);
		this.add(tool);
		
		this.loadSplitPane();
		
		TEP.setEvent();

		setVisible(true);
	}
	
	private void loadSplitPane() {
		//설정
		this.add(mainPane);
		mainPane.setLayout(new BorderLayout());
		mainPane.add(tool, BorderLayout.NORTH);
		mainPane.add(rightSplitPane, BorderLayout.CENTER);
		
		rightSplitPane.setContinuousLayout(true);
		leftSplitPane.setContinuousLayout(true);
		rightSplitPane.setLeftComponent(leftSplitPane);
		
		//분리
		rightSplitPane.setDividerLocation((int)this.getSize().getWidth()*3/4);
		rightSplitPane.setDividerSize(15);
		leftSplitPane.setDividerLocation((int)this.getSize().getWidth()/4);
		leftSplitPane.setDividerSize(15);
		
		//컴포넌트 설정
		rightSplitPane.setRightComponent(AP);
		leftSplitPane.setRightComponent(MMP);
		leftSplitPane.setLeftComponent(TEP);
	}
	
	public static void main(String [] args) {
		MainFrame mainProgram = new MainFrame();
	}
}
