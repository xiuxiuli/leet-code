package backtracking;

public class _46_Permutations {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // 如果这个元素在当前路径上已经被用过了，跳过
            if(used[i]) continue;

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}