package linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 创建 dummy 节点，简化删除头节点的边界情况
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 2. fast 先往前走 n + 1 步
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        // 3. fast 和 slow 同时移动，直到 fast 到达链表末尾 null
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        // 4. slow 此时指向待删除节点的前一个节点，执行删除
        slow.next = slow.next.next;

        return dummy.next;
    }
}