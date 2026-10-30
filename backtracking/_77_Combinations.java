package backtracking;

public class _77_Combinations {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path =  new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return result;
    }

    private void backtrack(int n, int k, int start) {
        // 1. 终止条件：当 path 中的元素个数达到 k 时，保存结果并返回
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 2. 单层逻辑：遍历当前层次所有可选的元素
        for(int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);        // 处理节点（选择）
            backtrack(n, k, i + 1);     // 递归：控制树的深度，下一层从 i + 1 开始
            path.remove(path.size() - 1);   // 回溯：撤销选择，恢复现场
        }
    }
}