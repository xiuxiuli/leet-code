/**
 * Definition for a binary tree node.
 * /
public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode curNode, TreeNode p, TreeNode q) {
        //找到P或找到Q或到了尽头，返回祖先节点
        if(curNode == null || curNode == p || curNode ==q ) return curNode;

        TreeNode leftAncestor = lowestCommonAncestor(curNode.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(curNode.right, p, q);

        if(leftAncestor != null && rightAncestor != null){
            return curNode; // 左右都有，说明 curNode 就是分叉点
        }

        return leftAncestor != null ? leftAncestor : rightAncestor;
    }
}