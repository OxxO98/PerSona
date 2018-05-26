package TextEditorSystem;

import System.*;
import Graphic.TextEditorPane;

public class MakeTexttoTree {
	/*
	 * text�� �޾Ƽ� tree�� ������ִ� �ý���
	 * text���۷����� �޾Ƽ� setTree�� MainSystem�� currentIndex��ġ�� tree����
	 * startMake�����Ҷ����� ���� ����
	 */
	
	static Tree tree;
	
	static String originalStr;
	static String [] splitedStr;
	//public�޼ҵ�
	public static void startMake(TextEditorPane TEP) {
		MainSystem.setTree(new Tree());
		MakeTexttoTree.tree = MainSystem.getCurrentTree();
		//null�ϋ��� ���� ���� null�� �ƴϸ� �׳� �� ���� X��
		MakeTexttoTree.originalStr = TEP.getText();
		MakeTexttoTree.splitedStr = MakeTexttoTree.originalStr.split("\n");
		
		MakeTexttoTree.makeTree();
		//Ȯ�ο�
		MakeTexttoTree.tree.showTree();
		MainSystem.setTree(MakeTexttoTree.tree);
	}
	//private�޼ҵ�
	private static int getTextLevel(String str) {
		int level = 0;
		while(true) {
			if(str.charAt(level) != '\t') {
				break;
			}
			level++;
		}

		return level;
	}
	private static void makeTree() {
		TreeNode selectedNode = tree.root;
		//root ����
		for(int i = 0; i < splitedStr.length; i++) {
			try {
				if(MakeTexttoTree.isChild(splitedStr[i-1], splitedStr[i]) == true) {
					//ù child�ϰ��
					selectedNode.setChild(new TreeNode());
					selectedNode.getChild().setParent(selectedNode);
					selectedNode.setLink(selectedNode.getChild().getThisLinkIndex(), (selectedNode.getChild().getThisLinkIndex()+2)%4);
					selectedNode = selectedNode.getChild();
				}else if(MakeTexttoTree.isSibling(splitedStr[i-1], splitedStr[i]) == true) {
					//sibling�ϰ��
					selectedNode.setSibling(new TreeNode());
					selectedNode.getSibling().setParent(selectedNode.getParent());
					selectedNode.setLink(selectedNode.getSibling().getThisLinkIndex(), (selectedNode.getSibling().getThisLinkIndex()+2)%4);
					selectedNode = selectedNode.getSibling();
				}else {
					//�Ѵ� �ƴϰ� Ž�� �ؾ���...
					selectedNode = MakeTexttoTree.isWhere(MakeTexttoTree.getTextLevel(splitedStr[i]));
					selectedNode.setSibling(new TreeNode());
					selectedNode.getSibling().setParent(selectedNode.getParent());
					selectedNode.setLink(selectedNode.getSibling().getThisLinkIndex(), (selectedNode.getSibling().getThisLinkIndex()+2)%4);
					selectedNode = selectedNode.getSibling();
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				selectedNode = tree.root;
			}
			selectedNode.setLevel(MakeTexttoTree.getTextLevel(splitedStr[i]));
			selectedNode.setData(splitedStr[i].substring(selectedNode.getLevel()));
		}
	}
	private static boolean isChild(String parentStr, String childStr) {
		if(MakeTexttoTree.getTextLevel(parentStr) < MakeTexttoTree.getTextLevel(childStr)) {
			return true;
		} else {
			return false;
		}
	}
	private static boolean isSibling(String parentStr, String childStr) {
		if(MakeTexttoTree.getTextLevel(parentStr) == MakeTexttoTree.getTextLevel(childStr)) {
			return true;
		} else {
			return false;
		}
	}
	//Sibling��ġ ã���ֱ�
	private static TreeNode isWhere(int level) {
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
