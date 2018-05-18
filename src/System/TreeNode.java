package System;

public class TreeNode {
	private int level;
	private String data;
	
	private TreeNode parent;
	private TreeNode child;
	private TreeNode sibling;
	//생성자
	public TreeNode() {
		this.parent = null;
		this.child = null;
		this.sibling = null;
	}
	public TreeNode (int level) {
		this.level = level;
		this.parent = null;
		this.child = null;
		this.sibling = null;
	}
	public TreeNode (String data) {
		this.data = data;
		this.parent = null;
		this.child = null;
		this.sibling = null;
	}
	public TreeNode(int level, TreeNode child, TreeNode sibling) {
		this.level = level;
		this.child = child;
		this.sibling = sibling;
	}
	//메소드
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
	public String getData() {
		return this.data;
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
	public void setData(String data) {
		this.data = data;
	}
	public String toString(){
		String retStr = "";
		for(int i = 0; i < this.getLevel(); i++) {
			retStr = retStr.concat("\t");
		}
		retStr = retStr.concat(this.getData());
		
		return retStr;
	}
	//응용
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
}
