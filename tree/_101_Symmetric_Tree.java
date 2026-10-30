pacakge tree;

public class _101_Symmetric_Tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode p, TreeNode q){
        if(p == null && q== null) return true;

        if(p ==null || q == null || p.val != q.val) return false;

        // p 的左边必须等于 q 的右边（外侧）
        // 并且 p 的右边必须等于 q 的左边（内侧）
        return dfs(p.left, q.right) && dfs(p.right , q.left);
    }
}