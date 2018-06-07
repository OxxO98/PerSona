package System;

import java.awt.Graphics;

import Event.ShowAttributeHandler;
import Graphic.*;
import MindMapSystem.makeoutLines;

public class TreeNode{
	private int level;
	//data�� MapNode�� protected�� ����
	
	private TreeNode parent;
	private TreeNode child;
	private TreeNode sibling;
	
	public MapNode Map = new MapNode();
	//������
	public TreeNode() {
		this.parent = null;
		this.child = null;
		this.sibling = null;
		this.Map.setInclude(this);
	}
	public TreeNode (int level) {
		this.level = level;
		this.parent = null;
		this.child = null;
		this.sibling = null;
		this.Map.setInclude(this);
	}
	//�ý��� ���� �޼ҵ�
	public TreeNode getParent() {
		return this.parent;
	}
	public TreeNode getSibling() {
		return this.sibling;
	}
	public TreeNode getChild() {
		return this.child;
	}
	public int getLevel() {
		return this.level;
	}
	public int getSiblingIndex() {
		if(this.getParent() == null) {
			//root
			return 0;
		}
		
		TreeNode node = this.getParent();
		int index = 0;
		node = node.getChild(); //�̰� siblingó��
		
		while(true) {
			if(node.getSibling() == null) {
				break;
			}
			else {
				if(node == this) {
					break;
				}
				node = node.getSibling();
				index++;
			}
		}
		return index;
	}
	public void setParent(TreeNode newNode) {
		this.parent = newNode;
	}
	public void setChild(TreeNode newNode) {
		this.child = newNode;
		newNode.setLevel(this.level+1);
	}
	public void setSibling(TreeNode newNode) {
		this.sibling = newNode;
		newNode.setLevel(this.level);
	}
	public void setLevel(int newLevel) {
		this.level = newLevel;
	}
	public void setClear() {
		this.child = null;
		this.sibling = null;
		this.parent = null;
	}
	//
	public String toString(){
		String retStr = "";
		for(int i = 0; i < this.getLevel(); i++) {
			retStr = retStr.concat("\t");
		}
		retStr = retStr.concat(Map.getData());
		
		return retStr;
	}
	public String showInfo() {
		String str1, str2, str3, str4, str5;
		
		str1 = Map.getX() + ",\t" + Map.getY() +"\t" + this.getSiblingIndex() + "\n";
		str2 = "Data\t" + Map.getData() + "\n";
		if(this.getParent() != null) {
			str3 = "Parent\t" + this.getParent().Map.getData() + "\n";
		}else {
			str3 = "null\n";
		}
		if(this.getSibling() != null) {
			str4 = "Sibling\t" + this.getSibling().Map.getData() + "\n";
		}
		else {
			str4 = "null\n";
		}
		if(this.getChild() != null) {
			str5 = "Child\t" + this.getChild().Map.getData() + "\n";
		}
		else {
			str5 = "null\n";
		}
		return str1 + str2 + str3 + str4 + str5;
	}
	//���� child�� sibling�� �ִ��� Ȯ���Ѵ�.
	public TreeNode hasNext() {
		if(this.getChild() != null) {
			return this.getChild();
		}
		else {
			if(this.getSibling() != null) {
				return this.getSibling();
			}
			else {
				return null;
			}
		}
	}
	//Link���� �޼ҵ�
	/*
	 * MapNode���� critetriaLink�� protected��
	 * �ٸ� �޼ҵ�鵵 ��κ� protected�� �����ؼ� ���� ����
	 */
	public int getThisLinkIndex() {
		//Parent�� ����� ��ġ(Parent����)
		//root��
		int Index = 0;
		if(this.getParent() == MainSystem.getCurrentTree().root) {
			//root��
			return this.getSiblingIndex();
		}
		else {
			Index = this.getParent().getThisLinkIndex() + 3 + this.getSiblingIndex();
		}
		return Index%4;
	}
	public void setLink(int ParentIndex, int Index) {
		Map.criteria[Index].setLink(true);
		Map.criteria[Index].linkedPoint = this.getParent().Map.criteria[ParentIndex];
		this.getParent().Map.criteria[ParentIndex].setLink(true);
		this.getParent().Map.criteria[ParentIndex].linkedPoint = Map.criteria[Index];
	}
	public void refactorLink() {
		if(makeoutLines.filterLine(this) != -1) {
			this.Map.criteria[makeoutLines.filterLine(this)].expressLine();
		}
		
		TreeNode node = this.getChild();
		if(node == null) {
			return;
		}
		while(true) {
			int index = makeoutLines.filterLine(node);
			if(index != -1) {
				node.Map.criteria[index].expressLine();
			}
			if(node.getSibling() == null) {
				break;
			}
			node = node.getSibling();
		}
	}
	//Debug��
	public void showLink() {
		for(int i = 0; i < 4; i++) {
			if(Map.criteria[i].getLink() != false) {
				System.out.println(Map.criteria[i].linkedPoint);
			}
			if(this.getParent().Map.criteria[i].getLink() != false) {
				System.out.println(this.getParent().Map.criteria[i].linkedPoint);
			}
		}
	}
}
