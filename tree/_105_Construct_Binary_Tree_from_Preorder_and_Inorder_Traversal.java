package tree;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    private Map<Integer, Integer> inOrderMap = new HashMap<>();
    private int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1. 把中序数组存入哈希表 （值: 索引）
        for(int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        // 2. 开始递归构建二叉树，范围是整张中序遍历地图 [0, inorder.length - 1]
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int inorderLeft, int inorderRight){
        // 如果左边界大于右边界，说明当前子树已经没有节点了，返回 null
        if(inorderLeft > inorderRight) return null;

        // 1. 前序数组的当前位置：当前的根节点
        int rootVal = preorder[preOrderIndex];
        TreeNode root = new TreeNode(rootVal);

        // 2. 前序指针向后移动，为下一个子树的根节点做准备
        preOrderIndex++;

        // 3. 在中序数组中找到当前根节点的位置，从而划分左右子树
        int rootInorderIndex = inOrderMap.get(rootVal);

        // 4. 递归构建左子树和右子树
        // 注意：由于前序数组 [根 -> 左 -> 右]，所以这里必须先递归左子树，再递归右子树
        root.left = dfs(preorder, inorderLeft, rootInorderIndex - 1);
        root.right = dfs(preorder, rootInorderIndex + 1, inorderRight);
        
        return root;
    }
}