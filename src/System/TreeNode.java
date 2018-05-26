package System;

import Graphic.*;

public class TreeNode extends MapNode{
	private int level;
	//data는 MapNode에 protected로 구현
	
	private TreeNode parent;
	private TreeNode child;
	private TreeNode sibling;
	//생성자
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
	//시스템 관련 메소드
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
		node = node.getChild(); //이게 sibling처음
		
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
		// node와 비교
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
	//응용 child나 sibling이 있는지 확인한다.
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
	//Link관련 메소드
	/*
	 * MapNode에서 critetriaLink는 protected로
	 * 다른 메소드들도 대부분 protected로 선언해서 접근 가능
	 */
	public int getThisLinkIndex() {
		//Parent에 연결될 위치(Parent기준)
		//root씀
		int Index = 0;
		if(this.getParent() == MainSystem.getCurrentTree().root) {
			//root임
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
