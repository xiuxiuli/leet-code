package backtracking;

public class _40_Combination_Sum_II {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path= new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 1. 核心关键：必须先排序，把相同的数字放在一起
        Arrays.sort(candidates);
        
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
            // 2. 核心关键：树层去重（跳过同层重复的元素）
            if(i > startIndex && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i+1);
            path.remove(path.size()-1);
        }
    }
}