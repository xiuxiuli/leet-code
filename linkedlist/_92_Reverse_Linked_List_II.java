package linkedlist;

class _92_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // 1. prev定位到待反转区间的前一个节点 (走 left - 1 步)
        //[1(prev)] -> [2(cur)] -> [3] -> [4] -> [5]
        for(int i = 0; i < left - 1; i++){
            prev = prev.next;
        }

        // cur 始终固定在反转子链表的首个节点（最终会变成子链表的尾节点）
        ListNode cur = prev.next;

        // 2. 头插法：每次将 cur 的下一个节点移到 prev 之后
        for(int i = 0; i < right - left; i++){
            ListNode next = cur.next; // 暂存待抽取的节点 next = 3
            cur.next = next.next;       //2 -> 4 -> 5
            next.next = prev.next;      //3(next.nex) -> 2 -> 4 -> 5
            prev.next = next;  // [1(prev)] -> [3] -> [2(cur)] -> [4] -> [5]
        }
        return dummy.next;
    }
}