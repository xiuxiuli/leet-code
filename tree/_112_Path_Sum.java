package tree;/**
 * _112_Path_Sum
 */
public class _112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if(root.left == null && root.right == null) return root.val == targetSum;

        boolean leftHasPathSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightHasPathSum = hasPathSum(root.right, targetSum - root.val);
        
        return leftHasPathSum || rightHasPathSum;
    }
}