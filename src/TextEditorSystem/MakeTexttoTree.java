package TextEditorSystem;

import System.Tree;
import System.TreeNode;
import Graphic.TextEditorPane;

public class MakeTexttoTree {
	Tree tree = new Tree();
	String originalStr;
	String [] splitedStr;
	
	public MakeTexttoTree(TextEditorPane TextEditor) {
		originalStr = TextEditor.getText();
		splitedStr = originalStr.split("\n");
		
		this.MakeTree();
		tree.showTree();
	}
	//메소드
	public Tree getTree() {
		return this.tree;
	}
	//private메소드
	private int getTextLevel(String str) {
		int level = 0;
		while(true) {
			if(str.charAt(level) != '\t') {
				break;
			}
			level++;
		}
		return level;
	}
	private void MakeTree() {
		TreeNode selectedNode = tree.root;
		//root 생성
		for(int i = 0; i < splitedStr.length; i++) {
			try {
				if(this.isChild(splitedStr[i-1], splitedStr[i]) == true) {
					selectedNode.setChild(new TreeNode());
					selectedNode.getChild().setParent(selectedNode);
					selectedNode = selectedNode.getChild();
				}else if(this.isSibling(splitedStr[i-1], splitedStr[i]) == true) {
					selectedNode.setSibling(new TreeNode());
					selectedNode.getSibling().setParent(selectedNode.getParent());
					selectedNode = selectedNode.getSibling();
				}else {
					selectedNode = this.isWhere(this.getTextLevel(splitedStr[i]));
					selectedNode.setSibling(new TreeNode());
					selectedNode.getSibling().setParent(selectedNode.getParent());
					selectedNode = selectedNode.getSibling();
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				selectedNode = tree.root;
			}
			selectedNode.setLevel(this.getTextLevel(splitedStr[i]));
			selectedNode.setData(splitedStr[i].substring(selectedNode.getLevel()));
		}
	}
	private boolean isChild(String parentStr, String childStr) {
		if(this.getTextLevel(parentStr) < this.getTextLevel(childStr)) {
			return true;
		} else {
			return false;
		}
	}
	private boolean isSibling(String parentStr, String childStr) {
		if(this.getTextLevel(parentStr) == this.getTextLevel(childStr)) {
			return true;
		} else {
			return false;
		}
	}
	//Sibling위치 찾아주기
	private TreeNode isWhere(int level) {
		TreeNode selectedNode = tree.getLastRightNode();
		while(true) {
			if(selectedNode.getLevel() == level) {
				break;
			}
			selectedNode = selectedNode.getParent();
		}
		while(true) {
			if(selectedNode.getSibling() == null) {
				break;
			}
			selectedNode = selectedNode.getSibling();
		}
		return selectedNode;
	}
}
