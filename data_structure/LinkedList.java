package data_structure;

public class LinkedList<E> {
    private class Node {
        E e;
        Node next;

         // contructor
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    // private Node head;
    private Node dummyHead;
    private int size;

    // contructor
    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int index){
        if (!isIndexValid(index)){
            throw new IllegalArgumentException("index out of bound");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++){
            cur = dummyHead.next;
        }
        return cur.e;
    }

    public E set(int index, E e){
        Node node = getNode(index);
        node.e = e;
        return node.e;
    }

    public void add(int index, E e){
        if (!isIndexValid(index)){
            throw new IllegalArgumentException("index out of bound");
        }
        Node prev = dummyHead;
        for (int i=0; i < index; i++){
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    private Node getNode(int index){
        if (!isIndexValid(index)){
            throw new IllegalArgumentException("index out of bound");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++){
            cur = dummyHead.next;
        }
        return cur;
    }

    private boolean isIndexValid(int index){
        return index >= 0 || index < size;
    }
}
