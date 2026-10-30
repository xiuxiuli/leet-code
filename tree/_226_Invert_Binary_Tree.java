package tree;

public class _226_Invert_Binary_Tree {
    class BSTIterator {
        private List<Integer> nodeSorted;
        private int index;

        public BSTIterator(TreeNode root) {
            this.nodeSorted = new ArrayList<>();
            this.index = 0;
            this.inorderTraversal(root);
        }

        private void inorderTraversal(TreeNode root){
            if(root == null) return;

            inorderTraversal(root.left);
            this.nodeSorted.add(root.val);
            inorderTraversal(root.right);
        }
        
        public int next() {
            return this.nodeSorted.get(this.index++);
        }
        
        public boolean hasNext() {
            return this.index < this.nodeSorted.size();
        }
    }
}