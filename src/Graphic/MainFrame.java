package Graphic;

import Graphic.*;
import Graphic.FileDialog;
import System.MainSystem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

import Event.WindowStateHandler;

import java.awt.*;

public class MainFrame extends JFrame {

	protected MenuBar menu = new MenuBar();
	protected ToolBar tool = new ToolBar();
	
	public JPanel mainPane = new JPanel();
	public JSplitPane rightSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	public JSplitPane leftSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	public AttributePane AP = new AttributePane(this);
	public TextEditorPane TEP = new TextEditorPane(this);
	public MindMapPane MMP = new MindMapPane(this);
 
	public JScrollPane MMPScrollPane = new JScrollPane();
	public FileDialog saveDlog = new FileDialog();
	public FileDialog openDlog = new FileDialog();
	
	public MainFrame() {		
		this.setJMenuBar(menu);
		this.add(tool);
		
		this.loadSplitPane();
		
		TEP.setEvent();
		this.setEvent();
		
		setTitle("MindMap Program");
		setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		leftSplitPane.setRightComponent(MMPScrollPane);
		MMP.setPreferredSize(MainSystem.defaultMMPSize);
		MMPScrollPane.setViewportView(MMP);
		MMPScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		MMPScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		leftSplitPane.setLeftComponent(TEP);
	}
	private void setEvent() {
		this.addComponentListener(new WindowStateHandler());
	}
	
	public static void main(String [] args) {
		MainSystem.start();
	}
}
