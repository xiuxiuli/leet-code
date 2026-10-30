public class _456_132_Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        if (n < 3) return false;

        // two 用来存储 132 模式中的 '2' (即 nums[k])
        // 我们希望 two 尽可能大，这样 nums[i] < two 就更容易满足
        int two = Integer.MIN_VALUE;
        
        int[] stack = new int[n];
        int top = -1;

        for(int i = n -1; i >= 0; i--){
            if (nums[i] < two) return true; //找到1，同时2也符合小于3的要求， 3在栈底

            while (top != -1 && nums[i] > stack[top]){
                two = stack[top--];
            }
            stack[++top] = nums[i];
        }
        return false;
    }
}
