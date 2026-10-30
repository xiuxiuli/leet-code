package heap;

public class _23_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
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
        class Solution {
            public ListNode mergeKLists(ListNode[] lists) {
                if(lists == null || lists.length == 0) return null;

                PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val- b.val);

                for(ListNode head : lists){
                    if(head != null){
                        minHeap.offer(head);
                    }
                }

                // 3. 经典的哑节点（Dummy Node）技巧，用来辅助构建新链表
                ListNode dummy = new ListNode(0);
                ListNode cur = dummy;

                // 4. 动态维护堆
                while(!minHeap.isEmpty()){
                    ListNode node = minHeap.poll();

                    cur.next = node;
                    // cur = cur.next;
                    cur = node;

                    if(node.next != null) {
                        minHeap.offer(node.next);
                    }
                } 

                return dummy.next;
            }
        }
    }
}