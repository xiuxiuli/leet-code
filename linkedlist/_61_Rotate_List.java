package linkedlist;

public class _61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        // 1. 统计长度并找到尾节点
        int len = 1;
        ListNode tail = head;
        while(tail.next != null) {
            len++;
            tail = tail.next;
        }

        // 2. 计算有效移动步数
        k = k % len;
        if (k == 0) return head;

        // 3. 尾部连向头部，形成闭环
        tail.next = head;

        // 4. 找到新尾节点（从 tail 出发走 n - k 步）
        ListNode newTail = tail;
        for(int i = 0; i < len - k; i++){
            newTail = newTail.next;
        }

        // 5. 记录新头节点并断开环
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}