package System;

public class MainSystem implements TreeSystem{
	static Tree [] tree = new Tree[1];
	static int currentTreeIndex = 0;
	
	//TreeSystem
	public void addTree(Tree tree) {
		Tree [] savedTree = new Tree[MainSystem.tree.length+1];
		for(int i = 0; i < MainSystem.tree.length; i++) {
			savedTree[i] = MainSystem.tree[i];
		}
		MainSystem.tree = savedTree;
	}
	public Tree getTree(int treeIndex) {
		return MainSystem.tree[treeIndex];
	}
	public static void setTree(Tree tree) {
		MainSystem.tree[MainSystem.currentTreeIndex] = tree;
	}
	public static Tree getCurrentTree() {
		return MainSystem.tree[MainSystem.currentTreeIndex];
	}
}
