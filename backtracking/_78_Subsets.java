package backtracking;

public class _78_Subsets {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0); // 从 index 0 开始
        return result;
    }

    private void backtrack(int[] nums, int startIndex) {
        // 1. 无条件收集当前节点：每个节点都是一个子集！
        result.add(new ArrayList<>(path));

        for(int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i+1);
            path.remove(path.size() - 1);
        }
    }
}