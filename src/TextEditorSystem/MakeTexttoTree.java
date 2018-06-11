package TextEditorSystem;

import System.*;
import Event.ShowAttributeHandler;
import Graphic.TextEditorPane;
import Graphic.*;

public class MakeTexttoTree {
	/*
	 * text�� �޾Ƽ� tree�� ������ִ� �ý���
	 * text���۷����� �޾Ƽ� setTree�� MainSystem�� currentIndex��ġ�� tree����
	 * startMake�����Ҷ����� ���� ����
	 */
	
	static String originalStr;
	static String [] splitedStr;
	//public�޼ҵ�
	public static boolean startMake() {
		TextEditorPane TEP = MainSystem.getFrame().TEP;
		
		if(TEP.getText().equals("") == true) {
			return false;
		}
		
		MainSystem.setTree(new Tree());
		Tree tree = MainSystem.getCurrentTree();
		//null�ϋ��� ���� ���� null�� �ƴϸ� �׳� �� ���� X��
		MakeTexttoTree.originalStr = TEP.getText();
		MakeTexttoTree.splitedStr = MakeTexttoTree.originalStr.split("\n");
		
		if(MakeTexttoTree.isVaildTree(MakeTexttoTree.splitedStr) == false) {
			return false;
		}
		
		MakeTexttoTree.makeTree();
		//Ȯ�ο�
		tree.showTree();
		MainSystem.setTree(tree);
		
		return true;
	}
	//private�޼ҵ�
	private static int getTextLevel(String str) {
		int level = 0;
		try {
			while(true) {
				if(str.charAt(level) != '\t') {
					break;
				}
				level++;
			}
		}
		catch(StringIndexOutOfBoundsException e) {
			
		}
		

		return level;
	}
	private static void makeTree() {
		Tree tree = MainSystem.getCurrentTree();
		
		TreeNode selectedNode = tree.root;
		//root ����
		for(int i = 0; i < splitedStr.length; i++) {
			try {
				if(MakeTexttoTree.isChild(splitedStr[i-1], splitedStr[i]) == true) {
					//ù child�ϰ��
					selectedNode.setChild(new TreeNode());
					selectedNode.getChild().setParent(selectedNode);
					selectedNode = selectedNode.getChild();
					
				}else if(MakeTexttoTree.isSibling(splitedStr[i-1], splitedStr[i]) == true) {
					//sibling�ϰ��
					selectedNode.setSibling(new TreeNode());
					selectedNode.getSibling().setParent(selectedNode.getParent());
					selectedNode = selectedNode.getSibling();
				}else {
					//�Ѵ� �ƴϰ� Ž�� �ؾ���...
					selectedNode = MakeTexttoTree.isWhere(MakeTexttoTree.getTextLevel(splitedStr[i]));
					selectedNode.setSibling(new TreeNode());
					selectedNode.getSibling().setParent(selectedNode.getParent());
					selectedNode = selectedNode.getSibling();
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				selectedNode = tree.root;
			}
			if(selectedNode != tree.root) {
				selectedNode.setLink(selectedNode.getThisLinkIndex(), (selectedNode.getThisLinkIndex()+2)%4);
			}
			selectedNode.setLevel(MakeTexttoTree.getTextLevel(splitedStr[i]));
			selectedNode.Map.setData(splitedStr[i].substring(selectedNode.getLevel()));
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
		Tree tree = MainSystem.getCurrentTree();
		
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
	//splitedStr�� Ʈ���� �Ǵ��� Ȯ��
	private static boolean isVaildTree(String [] SplitStr) {
		int rootNum = 0;
		//root�� ������
		if(SplitStr[0].equals("")) {
			return false;
		}
		
		for(int i = 0; i < SplitStr.length; i++) {
			//�����Ͱ� ������
			if(SplitStr[i].substring(MakeTexttoTree.getTextLevel(SplitStr[i])).equals("")) {
				return false;
			}
			//root����
			if(MakeTexttoTree.getTextLevel(SplitStr[i]) == 0) {
				rootNum++;
			}
		}
		//root�������϶�
		if(rootNum > 1) {
			return false;
		}
		return true;
	}
}
