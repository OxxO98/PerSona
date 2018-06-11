package Graphic;

import javax.swing.*;

import Event.ApplyAttributeHandler;
import Event.TexttoTreeApplyHandler;

import java.awt.geom.*;
import java.awt.*;
import MenuHandler.*;

public class MenuBar extends JMenuBar {
	
	private JMenu [] Menu = new JMenu[7];
	private JMenuItem [][] MenuItem = new JMenuItem[7][];
	
	private String [][] MenuString = {
			{"새로 만들기","열기", "저장", "다른 이름으로 저장","닫기"},
			{"적용", "변경"},
			{"a", "b"},
			{"c"},
			{"중앙 이동"},
			{"새창으로 열기"},
			{"도움말"}
		};
	
	private Graphics2D vector;
	private Color ForeGroundColor = new Color(0xFFFFFF);
	private Color BackGroundColor = new Color(0x303030);
	
	public void paintComponent(Graphics g) {
		vector = (Graphics2D)g;
		vector.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Rectangle2D rect = new Rectangle2D.Double(2, 2, this.getWidth()-4, this.getHeight()-4);
		Stroke stroke = new BasicStroke(2);
		vector.setStroke(stroke);
		vector.draw(rect);
		vector.setPaint(ForeGroundColor);
		vector.fill(rect);
		
//		this.setLayout(null);
	}
	
	public MenuBar() {
		Menu[0] = new JMenu("File");
		Menu[1] = new JMenu("Edit");
		Menu[2] = new JMenu("Type");
		Menu[3] = new JMenu("Select");
		Menu[4] = new JMenu("View");
		Menu[5] = new JMenu("Window");
		Menu[6] = new JMenu("Help");
		
		//메뉴 아이텐 추가
		for(int i = 0; i < Menu.length; i++) {
			this.SetMenuItem(i, MenuString[i]);
			for(int j = 0; j < MenuString[i].length; j++) {
				Menu[i].add(MenuItem[i][j]);
			}
			this.add(Menu[i]);
		}
		this.setEvent();
		this.setVisible(true);
	}
	private void SetMenuItem(int index, String [] arg){
		MenuItem[index] = new JMenuItem[arg.length];
		for(int i = 0; i<arg.length; i++) {
			MenuItem[index][i] = new JMenuItem(arg[i]);
		}
	}
	
	private void setEvent() {
		//File
		MenuItem[0][0].addActionListener(new ResetNewHandler());
		MenuItem[0][2].addActionListener(new SaveHandler());
		MenuItem[0][1].addActionListener(new OpenHandler());
		MenuItem[0][4].addActionListener(new ExitHandler());
		MenuItem[0][3].addActionListener(new SaveNewHandler());
		//Edit
		MenuItem[1][0].addActionListener(new TexttoTreeApplyHandler());
		MenuItem[1][1].addActionListener(new ApplyAttributeHandler());
	}
}

