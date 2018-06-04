package MindMapSystem;

import System.*;
import Graphic.*;
import Event.*;

public class makeoutLines {
	
	public static void makeout(Tree tree) {
		TreeNode node = tree.root.getChild();
		if(node == null) {
			return;
		}
		while(true) {
			int index = makeoutLines.filterLine(node);
			System.out.println(index);
			if(index != -1) {
				node.Map.criteria[index].expressLine();
			}
			if(tree.goNext(node) == null) {
				break;
			}
			node = tree.goNext(node);
		}
	}
	
	public static int filterLine(TreeNode node) {
		if(node.getParent() == null) {
			return -1;
		}
		for(int i = 0; i < 4; i++) {
			LinkPoint lp = node.Map.criteria[i].linkedPoint;
			if(lp != null) {
				if(lp.includedNode == node.getParent().Map) {
					return i;
				}
			}
		}
		return -1;
	}
}
