package System;

import Graphic.*;

public class TreeNode extends MapNode{
	private int level;
	//data�� MapNode�� protected�� ����
	
	private TreeNode parent;
	private TreeNode child;
	private TreeNode sibling;
	//������
	public TreeNode() {
		super();
		this.parent = null;
		this.child = null;
		this.sibling = null;
	}
	public TreeNode (int level) {
		super();
		this.level = level;
		this.parent = null;
		this.child = null;
		this.sibling = null;
	}
	public TreeNode (String data) {
		super();
		this.data = data;
		this.parent = null;
		this.child = null;
		this.sibling = null;
	}
	public TreeNode(int level, TreeNode child, TreeNode sibling) {
		super();
		this.level = level;
		this.parent = null;
		this.child = child;
		this.sibling = sibling;
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
	public String toString(){
		String retStr = "";
		for(int i = 0; i < this.getLevel(); i++) {
			retStr = retStr.concat("\t");
		}
		retStr = retStr.concat(this.getData());
		
		return retStr;
	}
	public boolean isEqual(TreeNode node) {
		// node�� ��
		if(this.data != node.data) {
			return false;
		}
		return true;
	}
	public String showInfo() {
		String str1, str2, str3, str4, str5;
		
		str1 = this.getX() + ",\t" + this.getY() +"\t" + this.getSiblingIndex() + "\n";
		str2 = "Data\t" + this.getData() + "\n";
		if(this.getParent() != null) {
			str3 = "Parent\t" + this.getParent().getData() + "\n";
		}else {
			str3 = "null\n";
		}
		if(this.getSibling() != null) {
			str4 = "Sibling\t" + this.getSibling().getData() + "\n";
		}
		else {
			str4 = "null\n";
		}
		if(this.getChild() != null) {
			str5 = "Child\t" + this.getChild().getData() + "\n";
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
	public void setLink(int Index, int ChildIndex) {
		if(this.hasLink(Index) == false || this.getChild().hasLink(ChildIndex) == false) {
			return;
		}
		
		this.criteria[Index].setLink(true);
		this.criteria[Index].linkedPoint = this.getChild().criteria[ChildIndex];
		this.getChild().criteria[ChildIndex].setLink(true);
		this.getChild().criteria[Index].linkedPoint = this.criteria[ChildIndex];
	}
}
