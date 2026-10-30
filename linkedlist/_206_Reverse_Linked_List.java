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
class _206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode cur = head;

        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
            cur = nextTemp;
        }
        return reverseHead;
    }
}