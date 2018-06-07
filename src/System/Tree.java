package System;

import java.awt.Dimension;
import java.awt.Rectangle;

import MindMapSystem.makeShellMap;

public class Tree {
	public TreeNode root = new TreeNode(0);
	
	public Tree() {	}
	//�޼ҵ�
	public void showTree() {
		TreeNode selectedNode = this.root;
		while(true) {
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
	
	public Dimension getTreeSize() {
		double width, height;
		
		TreeNode selectedNode = this.root;
		
		int maxLevel = 0;
						
		while(true) {
			if(selectedNode.getLevel() > maxLevel) {
				maxLevel = selectedNode.getLevel();
			}
			
			if(this.goNext(selectedNode) == null) {
				break;
			}
			selectedNode = this.goNext(selectedNode);
		}
		width = makeShellMap.defWidth + Math.pow(1+makeShellMap.ratioDistance, maxLevel)*makeShellMap.distance*2;
		height = makeShellMap.defHeight + Math.pow(1+makeShellMap.ratioDistance, maxLevel)*makeShellMap.distance*2;
		
		if(MainSystem.getFrame().MMP.getWidth() > width) {
			width = MainSystem.getFrame().MMP.getX()+MainSystem.getFrame().MMP.getWidth();
		}
		if(MainSystem.getFrame().MMP.getHeight() > height) {
			height = MainSystem.getFrame().MMP.getX()+MainSystem.getFrame().MMP.getWidth();
		}
		
		return new Dimension((int)width, (int)height);
	}
}
