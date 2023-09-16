package dfs;

import java.util.ArrayList;
import java.util.List;

import graph.AdjSet;
import graph.Graph;

//递归遍历图
public class ConnectCompMaxCnt {
	private Graph g;
	private boolean visited[];
	private int maxCount = 0;
	
	public ConnectCompMaxCnt(Graph g) {
		this.g = g;
		if (g == null) return;
		this.visited = new boolean[g.getV()];
		
		for (int v = 0; v < g.getV(); v++) {
			if (!visited[v]) {
				maxCount = Math.max(maxCount, dfs(v));
			}
		}
	}
		
	private int dfs(int v) {
		visited[v] = true;
		int res = 1;
		for (int w : g.getAdjVertex(v)) {
			if (!visited[w]) {
				dfs(w);
				res += dfs(w);
			}
		}
		return res;
	}
	
	public int getMaxCount(){
		return maxCount;
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_dfs.txt";
		Graph g = new AdjSet(graphDoc);
		ConnectCompMaxCnt max = new ConnectCompMaxCnt(g);
		System.out.println(max.getMaxCount());
	}
}
