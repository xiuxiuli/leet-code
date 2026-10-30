package heap;

public class _295_Find_Median_from_Data_Stream {

    class MedianFinder {
        private PriorityQueue<Integer> maxHeap; //左边
        private PriorityQueue<Integer> minHeap; //右边
        
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 大顶堆（逆序）
            minHeap = new PriorityQueue<>();    // 小顶堆（默认正序）
        }
        
        public void addNum(int num) {
            // 1. 先盲目送入大顶堆
            maxHeap.offer(num);

            // 2. 塞到左边后， 看看这个数是是不是比右边最小的值还要大，如果是，它属于右边队
            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                minHeap.offer(maxHeap.poll());
            }

            // 3. 这时检查左右两边的尺寸，进行有必要的调整了
            // 如果左边的 SIZE 比右边的大 2， 不行，
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            // 如果左边 SIZE 小于右边，不行的
            } else if(maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}