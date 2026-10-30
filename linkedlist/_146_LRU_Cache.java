package linkedlist;

public class LRUCache {

    /*
    活跃度规则：无论是因为 get 读取 还是 put 写入/更新，只要该数据被触碰到了，它就会立刻变成“最新数据”。

    淘汰规则（Eviction）：只有在插入全新的 key 且容量已满时，才会触发淘汰——精准淘汰掉那个最久没有被 get 或 put 触碰过的数据

    性能要求：无论数据量多大，get 和 put 都必须以 O(1) 常数时间 瞬间完成。
    */
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(){}

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;

    private Map<Integer, Node> map;
    private Node head, tail;    // 虚拟头尾哨兵节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    // 访问已有数据(get), 通过map找到对应节点
    // 从原位置扣出，移到头部（head.next），标记为最新
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.val;
    }

    // 如果加入新key，新节点插入到头部
    // 如果加入已有key, 更新该节点的value, 从原位扣出，移到头部(head.next）
    // 如果超容，从尾部前一个节点tail.prev淘汰，并同步从HashMap移除
    public void put(int key, int value) {
        Node node = map.get(key);

        if(node != null) {
            // 已存在：更新值并移到头部
            node.val = value;
            moveToHead(node);
        } else {
            // 不存在：创建新节点
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);

            // 超容：淘汰尾部最久未使用的节点
            if(map.size() > capacity){
                Node lru = removeTail();
                map.remove(lru.key); // 同步从 map 中移除
            }
        }
    }

    // 将已有节点移到最前（先删再插头）
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    // 从链表中剥离删除指定节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 在头哨兵后面插入新节点
    private void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除并返回尾部最久未用的真实节点
    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */