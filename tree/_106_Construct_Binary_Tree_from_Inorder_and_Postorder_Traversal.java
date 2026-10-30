package tree;

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;

        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return dfs(postorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] postorder, int inorderLeft, int inorderRight){
        if(inorderLeft > inorderRight) return null;

        int rootVal = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootVal);

        postorderIndex--;

        int rootInorderIndex = inorderMap.get(rootVal);

        root.right = dfs(postorder, rootInorderIndex + 1, inorderRight);
        root.left = dfs(postorder, inorderLeft, rootInorderIndex - 1);

        return root;
    }
}