package data_structure;

import java.util.*;

public class DirectGraph {
     // 构建有向图
    private static Map<Integer, List<Integer>> buildGraph(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>());
        }
        return graph;
    }

    private static Map<Integer, List<Integer>> buildGraph(int numCourse, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourse; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges){
            int from = edge[0], to = edge[1];

            graph.get(from).add(to);
        }
        return graph;

    }

    // DFS 从某个节点开始
    public static void dfsFromNode(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        visited.add(node);
        System.out.println(node);

        for (int neighbor: graph.getOrDefault(node, Collections.emptyList())){
            if (!visited.contains(neighbor)){
                dfsFromNode(graph, neighbor, visited);
            }
        }
    }

    // 0 = 未访问
    // 1 = 访问中（在递归栈里）
    // 2 = 已访问完成
    private static boolean dfsFromNode_HasCycle(Map<Integer, List<Integer>> graph, int node, int[] state){
        if (state[node] == 1) return true; // 找到环

        if (state[node] == 2) return false; // 已经处理过

        state[node] = 1; // 标记为“访问中”

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (dfsFromNode_HasCycle(graph, neighbor, state)){
                return true;
            }
        }
        state[node] = 2; // 标记为“访问完成”
        return false;
    }

    // 拓扑排序
    private static boolean dfsTopo(
        Map<Integer, List<Integer>> graph,
        int node,
        int[] state,
        List<Integer> order)
    {
        if (state[node] == 1) return true;

        if (state[node] == 2) return false;

        state[node] = 1;

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (dfsTopo(graph, neighbor, state, order)){
                return true;
            }
        }

        state[node] = 2;
        order.add(node);
        return false;
    }

    public static void main(String args[]){
         // 边列表 (from -> to)
        int[][] edges = {
            {0, 1}, 
            {0, 2},
            {1, 3},
            {2, 4}
        };

        //TEST 1.
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        Set<Integer> visited = new HashSet<>();

        System.out.println("Graph-1 DFS traversal: ");
        dfsFromNode(graph, 0, visited);

        //TEST 2. check cycle in graph
        // graph with cycle
        int[][] edges1 = {
                {0, 1},
                {1, 2},
                {2, 0}  // 加这个就是环
        };

        Map<Integer, List<Integer>> graph1 = buildGraph(edges1);
        int n = 3;
        int[] state = new int[n];

        boolean hasCycle = false;

        for(int i = 0; i < n; i++){
            if (dfsFromNode_HasCycle(graph1, i, state)) {
                hasCycle = true;
                break;
            }
        }

        System.out.println("Graph-2 has cycle:" + hasCycle);

        //TEST 3.
        int[][] edgesTopo = {
            { 0, 1 },
            { 0, 2 },
            { 1, 3 },
            { 2, 4 },
        };

        Map<Integer, List<Integer>> graphTopo = buildGraph(edgesTopo);

        // nTopo 要覆盖所有节点（0..4）
        int nTopo = 5;
        int[] stateTopo = new int[nTopo];
        List<Integer> order = new ArrayList<>();

        boolean hasCycleTopo = false;

        // 必须遍历所有节点（防止不连通）
        for (int i = 0; i < nTopo; i++){
            if (dfsTopo(graphTopo, i, stateTopo, order)) {
                hasCycleTopo = true;
                break;
            }
        }

        if (hasCycleTopo) {
            System.out.println("Topo: has cycle, no valid order.");
        } else {
            Collections.reverse(order); // 关键：后序收集，需要反转
            System.out.println("Topo order: " + order);
        }

    }

}