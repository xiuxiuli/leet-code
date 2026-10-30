package linkedlist;

public class _138_Copy_List_with_Random_Pointer {
    public Node copyRandomList_1(Node head) {
        if(head == null) return null;

        //原节点 -> 新克隆节点
        Map<Node, Node> map = new HashMap<>();

        // 1. 建立原节点与新节点的映射
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 2. 连接新节点的 next 和 random
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    public Node copyRandomList(Node head) {
        if(head == null) return head;

        // 1. 在每个原节点后面复制并插入新节点: A -> A' -> B -> B'
        Node cur = head;
        while(cur != null){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;

            cur = copy.next;
        }

        // 2. 复制 random 指针
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next; // 跳过 copy 节点
        }

        // 3. 拆分链表
        cur = head;
        Node dummy = new Node(0);
        Node copyCur = dummy;

        while(cur != null){
            Node nextOriginal = cur.next.next; // 记录下一个原节点

            // 提取克隆节点
            copyCur.next = cur.next;
            copyCur = copyCur.next;

            // 恢复原链表
            cur.next = nextOriginal;
            cur = nextOriginal;
        }
        return dummy.next;
    }
}