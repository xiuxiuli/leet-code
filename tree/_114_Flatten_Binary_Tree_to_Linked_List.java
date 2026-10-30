package tree;

public class _114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode cur = root;

        while(cur != null){
            if(cur.left != null){
                TreeNode p =cur.left; //p 是一个移动的pointer

                while(p.right!= null){
                    p = p.right;
                }

                // 1. 把原有的右子树接到左子树的最右节点后面
                p.right = cur.right;

                // 2. 把整棵左子树挪到右指针下
                cur.right = cur.left; 
                cur.left = null;
            }
            // 3. 继续准备处理下一个右节点
            cur = cur.right;
        }
    }
}