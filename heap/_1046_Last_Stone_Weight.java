package heap;

public class _1046_Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int stone: stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if(y != x){
                maxHeap.offer(y-x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
}