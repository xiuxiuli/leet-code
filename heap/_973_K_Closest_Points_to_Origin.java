package heap;

public class _973_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> {
            int d1 = p1[0] * p1[0] + p1[1] * p1[1];
            int d2 = p2[0] * p2[0] + p2[1] * p2[1];
            return Integer.compare(d2, d1); // 距离大的排在堆顶
        });

        for(int[] point : points){
            int x = point[0];
            int y = point[1];

            int d = x * x + y* y;

            if(maxHeap.size() < k){
                maxHeap.offer(point);
            } else {
                int[] top = maxHeap.peek();
                int topD = top[0] * top[0] + top[1]*top[1];

                if(d < topD){
                    maxHeap.poll();
                    maxHeap.offer(point);
                }    
            }
        }
        int [][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }

        return result;
    }
}