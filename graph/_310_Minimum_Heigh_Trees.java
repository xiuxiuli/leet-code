package graph;

public class _310_Minimum_Heigh_Trees{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 特判：如果只有一个节点，它自己就是根
        if(n == 1){
            return Collections.singletonList(0);
        }

        List<Set<Integer>> tree = new ArrayList<>();

        for(int i = 0; i < n; i++){
            tree.add(new HashSet<>());
        }

        int[] degree = new int[n];

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            tree.get(a).add(b);
            tree.get(b).add(a);
            degree[a]++;
            degree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();

        //为了找到中心，我们不能从内向外找，而是要从外向内“剥洋葱”
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) { //Degree==1， 说明它是叶子节点
                q.offer(i); 
            }
        }

        int remainNodes = n;

        while(remainNodes > 2){
            int size = q.size();
            remainNodes -= size;

            for(int i = 0; i < size; i++){
                int cur = q.poll();

                // 遍历这个叶子节点的邻居
                for(int neighbor: tree.get(cur)){
                    degree[neighbor]--;
                    if(degree[neighbor] == 1){
                        q.offer(neighbor);
                    }
                }
            }
        }
        // 4. 队列中剩下的就是最中心的根节点
        return new ArrayList<>(q);
    }

}