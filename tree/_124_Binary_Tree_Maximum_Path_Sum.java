package tree;

public class _124_Binary_Tree_Maximum_Path_Sum {
    // 全局变量，记录见过的最大路径和
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
       maxGain(root);

       return maxSum;
    }

    // 核心递归函数：计算当前节点能为上层提供的“单边最大贡献”
    private int maxGain(TreeNode node) {
        if(node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int curPathSum = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, curPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }
}