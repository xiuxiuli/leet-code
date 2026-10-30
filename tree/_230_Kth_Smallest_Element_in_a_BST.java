package tree;

public class _230_Kth_Smallest_Element_in_a_BST{
    // 你只要记住两句话：
    // 1. 只要是 BST，中序遍历（左-根-右）出来的数字就是从小到大排好序的。
    // 2. 只要是从小到大排好序的, 每到一个“根”节点, 干点活

    // 1. 死记硬背第一步：在外面定义两个全局变量（计数器和结果
    private int count = 0;
    private int result = 0;

    
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    // 2. 死记硬背第二步：背熟标准的“左 -> 根 -> 右”中序遍历框架
    private void dfs(TreeNode node, int k){
        // 【底线】空节点直接返回
        if (node == null) return;

        // 【左】
        dfs(node.left, k);

        //【中 - 根】干活了：计数器加1，到了k就收工
        count++;
        if(count == k){
            result = node.val;
            return;
        }

        // 【右】
        dfs(node.right, k);
    }
}