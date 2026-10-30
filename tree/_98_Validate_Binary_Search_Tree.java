package tree;

public class _98_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max){
        if(node == null) return true;

        // 只要当前节点的值越界了，说明不合法
        if(node.val <= min || node.val >= max) return false;

        // 递归左子树：上限变成 node.val；
        boolean leftIsGood = validate(node.left, min, node.val);
        // 递归右子树：下限变成 node.val
        boolean rightIsGood = validate(node.right, node.val, max);

        return leftIsGood && rightIsGood;
    }


    private long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        boolean leftIsGood = isValidBST(root.left);

        if(!leftIsGood) return false;

        if(root.val <= prev) return false;
        prev = root.val;

        boolean rightIsGood = isValidBST(root.right);
        return rightIsGood;
    }
}