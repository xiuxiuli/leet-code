package data_structure;

import java.util.*;

public class UndirectGraph {

    private boolean dfsFromNode(
        Map<Integer, List<Integer>> graph, 
        boolean[] visited, 
        int node, 
        int parent)
        {
            visited[node] = true;

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())){
                if (!visited[neighbor]){
                    if (dfsFromNode(graph, visited, neighbor, node)){
                        return true;
                    }
                } else if (neighbor != parent){
                    return true;
                }
            }
            return false;

        }

    public boolean hasCycle(int[][] edges, int n){
        // build graph
        Map<Integer, List<Integer>> undirectedGraph = new HashMap<>();

        // 给每个节点准备一个“邻居列表”
        // for (int i = 0; i < n; i++){
        //     undirectedGraph.put(i, new ArrayList<>());
        // }

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            undirectedGraph.putIfAbsent(u, new ArrayList<>());
            undirectedGraph.putIfAbsent(v, new ArrayList<>());

            undirectedGraph.get(u).add(v);  // u-v
            undirectedGraph.get(v).add(u);  // v-u
        }

        // ✅ 补齐所有节点（避免孤立点导致 graph.get(node) = null）
        for (int i = 0; i < n; i++) {
            undirectedGraph.putIfAbsent(i, new ArrayList<>());
        }

        // dfs graph for any unvisited node
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                if (dfsFromNode(undirectedGraph, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    // Graph Valid Tree
    //1. 是无向图 2. 没有环 3. 是连通的 , 4.边数必须是 n - 1
    public boolean isValidTree(int[][] edges, int n){
        if (edges.length != n-1) return false;

        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // ensure no circle
        // circle: neighbor in visted, neighbor is !parent
        boolean[] visited = new boolean[n];

        if (dfsFromNode(graph, visited, 0, -1)) return false;

        // 3. 是连通的
        for (boolean v : visited){
            if (!v) return false;
        }
        return true;
    }


    public static void main(String args[]) {

        // 4 = 一共有 4 个节点（0,1,2,3), edges = 边的列表
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}}; //0 — 1 — 2 — 3

        UndirectGraph undirectGraph = new UndirectGraph();

        System.out.println(undirectGraph.hasCycle(edges, n));

        System.out.println(undirectGraph.isValidTree(edges, n));
    }
}