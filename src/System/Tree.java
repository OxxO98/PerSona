package System;

public class Tree {
	public TreeNode root = new TreeNode(0);
	
	public Tree() {	}
	//메소드
	public void showTree() {
		TreeNode selectedNode = this.root;
		while(true) {
			System.out.println(selectedNode.toString());
			if(this.goNext(selectedNode) == null) {
				break;
			}
			selectedNode = this.goNext(selectedNode);
		}
	}
	public TreeNode getLastRightNode() {
		//트리 가장 오른쪽 노드
		TreeNode selectedNode = this.root;
		while(true) {
			if(selectedNode.getChild() == null) {
				break;
			}
			selectedNode = selectedNode.getChild();
			while(true) {
				if(selectedNode.getSibling() == null) {
					break;
				}
				selectedNode = selectedNode.getSibling();
			}
		}
		return selectedNode;
	}
	//private 메소드
	private TreeNode goNext(TreeNode node) {
		TreeNode selectNode = node;
		if(node.hasNext() != null) {
			return node.hasNext();
		}
		else {
			while(true) {
				if(selectNode.getSibling() != null) {
					return selectNode.getSibling();
				}
				if(selectNode == this.root) {
					return null;
				}
				selectNode = selectNode.getParent();
			}
		}
	}
}
