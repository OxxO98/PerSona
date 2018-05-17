package Graphic;

import Graphic.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	protected MenuBar menu = new MenuBar();
	protected ToolBar tool = new ToolBar();
	
	protected JSplitPane VerticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	protected JSplitPane rightSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	protected JSplitPane leftSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	protected AttributePane mainAttributePane = new AttributePane();
	protected TextEditorPane mainTextEditorPane = new TextEditorPane();
	protected MindMapPane mainMindMapPane = new MindMapPane();
	
	
	public MainFrame() {
		setTitle("MindMap Program");
		setSize(800,600);
		setVisible(true);
	
		this.setJMenuBar(menu);
		this.add(tool);
		
		this.loadSplitPane();
	}
	
	private void loadSplitPane() {
		//설정
		this.add(VerticalSplitPane);
		VerticalSplitPane.setTopComponent(tool);
		VerticalSplitPane.setBottomComponent(rightSplitPane);
		rightSplitPane.setContinuousLayout(true);
		leftSplitPane.setContinuousLayout(true);
		rightSplitPane.setLeftComponent(leftSplitPane);
		
		//분리
		rightSplitPane.setDividerLocation((int)this.getSize().getWidth()*3/4);
		rightSplitPane.setDividerSize(15);
		leftSplitPane.setDividerLocation((int)this.getSize().getWidth()/4);
		leftSplitPane.setDividerSize(15);
		
		//컴포넌트 설정
		rightSplitPane.setRightComponent(mainAttributePane);
		leftSplitPane.setRightComponent(mainMindMapPane);
		leftSplitPane.setLeftComponent(mainTextEditorPane);
	}
	
	public static void main(String [] args) {
		new MainFrame();
	}
}
