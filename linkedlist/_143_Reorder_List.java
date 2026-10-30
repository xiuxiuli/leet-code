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
class _143_Reorder_List {
    public void reorderList(ListNode head) {
        if(head == null | head.next == null) return;

        // 1. 快慢指针找链表中点
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow; // 中点就是slow

        // 2. 将链表断开，并反转后半段
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode reversedHead = null;
        ListNode cur = head2;

        while(cur != null){
            ListNode nextTemp = cur.next; //
            cur.next = reversedHead; //
            reversedHead = cur; //
            cur = nextTemp;
        }
        head2 = reversedHead; // head2 为反转后后半段的头节点

        ListNode p1 = head;
        ListNode p2 = head2;

        while(p2 != null){
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;

            p1.next = p2;
            p2.next = t1;

            p1 = t1;
            p2 = t2;
        }
    }
}