package linkedlist;

public class _25_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        for(int i = 0; i < len / k; i++) {
            cur = prev.next;
            
            // 像Swap转圈 一样
            // 原顺序：  [prev] -> [cur]  -> [next] -> [next.next]
            //                      └── 互换 ──┘
            // 新顺序：  [prev] -> [next] -> [cur]  -> [next.next]
            for(int j = 0; j < k - 1; j++){ 
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = cur;
        }
        return dummy.next;
    }
}