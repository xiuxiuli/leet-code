package backtracking;

public class _90_Subsets_II {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));

        for(int i = startIndex; i < nums.length; i++){
            if(i > startIndex && nums[i] == nums[i -1]) continue;
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}