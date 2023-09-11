package bTree;

class TreeNode<E> {
	E data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(E data){
		this.data = data;
		left = right = null;
	}
}
