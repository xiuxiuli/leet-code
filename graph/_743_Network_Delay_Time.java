package graph;

public class _743_Network_Delay_Time {
    //全程 k -> u -> v = (k -> u)  + (u -> v)
    //      数组            heap        map
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. 建图：graph记录 u -> v 的邻居距离
        // (u, {v, time})
        // Key是起点times[i][0]，Value是{终点[times[i][1], 耗时[times[i][2]]}
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time: times){
            graph.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // 2. 数组 dist[i] 记录 k -> v 的最短距离 (全程 k -> u -> v)
        // 从起点k到每个i点的当前已知的最快到达时间
        int[] dist = new int[n+1]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // 起点到自己的耗时是0

        // 3. 建最小堆，记录: 记录 k -> u 的最短距离
        // int[]{当前节点u, 从k到u的累计耗时}
        // 按照累计耗时从小到大排序（贪心）, node a = [u, 2min]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{k, 0});//k到k的耗时是0

        // 4. Dijkstra 核心骨架循环
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int curTime = cur[1];

            // 关键剪枝：如果弹出的耗时比已经记录的最短耗时还要大，直接跳过
            if(curTime > dist[u]) continue;

            // 如果当前节点没有出边，说明是死胡同，继续看下一个
            if(!graph.containsKey(u)) continue;

            // 遍历当前节点的所有邻居
            for(int[] neighbor : graph.get(u)){
                int v = neighbor[0];
                int weight = neighbor[1];

                // 松弛操作（Relaxation）：如果通过当前节点 u 走到 v 的时间更短 
                // “贪心比较，动态修正” 
                if(dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]}); // 把更优的选择送入堆中
                }
            }
        }

        // 5. 遍历 dist 数组，寻找全场收到信号最慢的那个时间
        int maxDelay = 0;
        // 注意：节点编号是从 1 到 n，所以从索引 1 开始遍历
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxDelay = Math.max(maxDelay, dist[i]);
        }
        return maxDelay;
    }
}