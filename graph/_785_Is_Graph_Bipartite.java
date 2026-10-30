package graph;

public class _785_Is_Graph_Bipartite{
     public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] colors = new int[n]; // 0: 未染色, 1: 颜色A, -1: 颜色B

        for(int i = 0; i < n; i++){
            // 如果没染过色，则开始染色。起始颜色设为 1
            if(colors[i] == 0) {
                if(!dfs(i, 1, graph, colors)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int colorA, int[][] graph, int[] colors){
        if(colors[node] != 0) { 
            // 真实颜色等于期望颜色：说明这条线两端的节点“一红一蓝”，安全无冲突！
            if (colors[node] == colorA) return true;  //如果另一边的节点是我的反颜色
            // 真实颜色不等于期望颜色：说明走了一圈回来，发现线两端的数字一样了，撞色冲突！
            else return false; 
        }

        // 1. 先给自己染色
        colors[node] = colorA;

        // 2. 遍历邻居，把颜色“传播”下去
        for(int neighbor : graph[node]){
            // 如果邻居已经染过色了，且跟我颜色一样 -> 冲突！
            if (!dfs(neighbor, -colorA, graph, colors)) return false;
        }
        return true;
    }
}