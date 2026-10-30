package backtracking;

public class _39_Combination_Sum {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path  = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrack(candidates, target, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int startIndex){
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0) return;

        for(int i = startIndex; i < candidates.length; i++){
            path.add(candidates[i]);

            // 关键点：这里传 i，代表下一个数依然可以选 candidates[i]（允许重复选择）
            backtrack(candidates, target - candidates[i], i);

            path.remove(path.size() - 1);
        }
    }
}