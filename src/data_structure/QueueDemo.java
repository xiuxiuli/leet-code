package data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo{
    public static void main(String[] args){
        Queue<Integer> queque = new LinkedList<>();
        queque.offer(5);
        queque.offer(10);
        queque.offer(1);
        queque.offer(17);
        queque.offer(8);
        queque.poll();
        queque.peek();
    }
}
