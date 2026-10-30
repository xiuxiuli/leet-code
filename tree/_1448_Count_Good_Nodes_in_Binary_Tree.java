package tree;

public class _1448_Count_Good_Nodes_in_Binary_Tree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar){
        if(node == null) return 0;

        int count = 0;

        if(node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }

        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
}