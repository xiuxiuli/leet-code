package data_structure;

import java.util.*;

public class GraphBuilder {

    // 1. 基础套路：List数组实现邻接表 (效率高于 HashMap)
    // int[][] edges (边列表)， 每一个子数组 [u, v] 代表的是一条连接线
    // 例如：[1, 2] 表示用户 1 和用户 2 是好友
    // 你需要手动构建一个邻接表（Adjacency List），比如 List<Integer>[] 或 Map<Integer, List<Integer>>

    private List<Integer>[] buildAdjacencyList(int n, int[][] edges, boolean isDirected) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);


            if (isDirected){
                graph[v].add(u);
            }
        }
        return graph;
    }

    // 2. 进阶套路：建图 + 入度表 (Topological Sort 必备)
    private Map<Integer, List<Integer>> buildWithIndegree(int n, int[][] edges, int[] indegree){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges){
            int from = edge[1]; // 注意：通常题目给的是 [course, preCourse]
            int to = edge[0];
            graph.get(from).add(to);
            indegree[to]++;
        }
        return graph;
    }

    // 3. 矩阵套路：方向数组 (Grid Problem 必备)
    private void traverseGrid(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        // 方向数组：上下左右
        int[][] dirs = {
            {-1, 0}, 
            {1, 0}, 
            {0, 1}, 
            {0, -1}
        };

        // 模拟在一个点 (r, c) 寻找邻居
        int r = 0, c = 0;
        for (int[] d : dirs) {
            int nextR = r + d[0];
            int nextC = c + d[1];

            // 越界检查标准模板
            if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols){
                // 执行逻辑，比如 if(grid[nextR][nextC] == 1) ...
            }
        }
    }

    public static void main(String[] args){
        GraphBuilder builder = new GraphBuilder();

        // 测试 1
        int[][] edges ={{0, 1}, {1, 2}, {2, 0}};
        List<Integer>[] adj = builder.buildAdjacencyList(2, edges, false);
        System.out.println("Adjacency List built successfully.");

        // 测试 2
        int[] indegree = new int[3];
        builder.buildWithIndegree(3, edges, indegree);
        System.out.println("Indegrees: " + Arrays.toString(indegree));
    }



}
