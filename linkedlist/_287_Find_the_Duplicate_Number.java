package linkedlist;

public class _287_Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int slow = nums[0]; // slow = slow.next
        int fast = nums[nums[0]]; //fast = slow.next.next

        // 阶段 1: 快慢指针在环内相遇
        // 第 1 次相遇：撞在环里的任意位置（不一定是重复数字）
        while(slow != fast) {
            slow = nums[slow]; // slow.next （每次走 1 步）
            fast = nums[nums[fast]];//fast.next.next （每次走 2 步）
        }

        //相遇： slow 4; fast 4 

        // 阶段 2: 寻找环的入口（重复元素）
        // 第 2 次相遇：通过步数补偿，精准撞在环的唯一入口（必定是重复数字）
        slow = 0;
        while (slow != fast){
            slow = nums[slow]; //slow.next
            fast = nums[fast]; //fast.next
        }
        return slow;
    }
}