package MindMapSystem;

import System.*;
import Graphic.*;
import Event.*;

public class makeoutLines {
	
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
