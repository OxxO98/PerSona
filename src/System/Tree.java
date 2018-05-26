package System;

public class Tree {
	public TreeNode root = new TreeNode(0);
	
	public Tree() {	}
	//�޼ҵ�
	public void showTree() {
		TreeNode selectedNode = this.root;
		while(true) {
//			System.out.println(selectedNode.toString());
			System.out.println(selectedNode.showInfo());
			if(this.goNext(selectedNode) == null) {
				break;
			}
			selectedNode = this.goNext(selectedNode);
		}
	}
	//���� ����
	public TreeNode getLastRightNode() {
		//Ʈ�� ���� ������ ���
		//Ʈ�� ���� ã�´�.
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
	public TreeNode goNext(TreeNode node) {
		/*
		 * �� ������ sibling�� ���ų� child�� ������
		 * ���ܰ��� sibling�� ��ȯ
		 * root -> child -> sibling��
		 */
		TreeNode selectNode = node;
		if(node.hasNext() != null) {
			//���� ���� children �̳� sibling�� ������ ��ȯ
			return node.hasNext();
		}
		else {
			while(true) {
				if(selectNode.getSibling() != null) {
					//sibling�� ������ sibling ��ȯ
					return selectNode.getSibling();
				}
				if(selectNode == this.root) {
					//root�� null��ȯ
					return null;
				}
				//parent�� �ö󰡼� sibling�� ã�´�.
				selectNode = selectNode.getParent();
			}
		}
	}
}
