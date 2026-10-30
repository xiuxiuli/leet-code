package heap;

public class _347_Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 创建小顶堆，堆里放的是 Map 的键值对 Entry
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap 
            = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(minHeap.size() < k){
                minHeap.offer(entry);
            } else if(minHeap.peek().getValue() < entry.getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}