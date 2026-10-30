package linkedlist;

class _86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        // 1. 创建两个虚拟头节点分别维护小于 x 和大于等于 x 的链表
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;
        ListNode cur = head;

        // 2. 遍历原链表，按值分流
        while(cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }

        large.next = null;
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}