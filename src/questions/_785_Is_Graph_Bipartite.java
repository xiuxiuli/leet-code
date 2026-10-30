package questions;

public class _785_Is_Graph_Bipartite {
    public boolean isBipartiteDFS(int[][] graph){
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++){
            if (color[i] == 0) {
                if (!dfs(graph, i, 1, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int node, int c, int[] color){
        color[node] = c;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                if (!dfs(graph, neighbor, -c, color)){
                    return false;
                }
            } else if (color[neighbor] == c) {
                return false;
            }
        }
        return true;
    }
}
