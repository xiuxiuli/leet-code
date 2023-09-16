package dfs;

import java.util.ArrayList;
import java.util.List;

import graph.AdjSet;
import graph.Graph;

//递归遍历图
public class ConnectComponentCount {
	private Graph g;
	private int ConnectCompCount;
	private boolean visited[];
	
	public ConnectComponentCount(Graph g) {
		this.g = g;
		if (g == null) return;
		
		this.ConnectCompCount = 0;
		
		this.visited = new boolean[g.getV()];
		
		for (int v = 0; v < g.getV(); v++) {
			if (!visited[v]) {
				dfs(v);
				ConnectCompCount++;
			}
		}
	}
		
	private void dfs(int v) {
		visited[v] = true;
		for (int w : g.getAdjVertex(v)) {
			if (!visited[w])
				dfs(w);
		}
	}

	public int getConnectCompCount() {
		return ConnectCompCount;
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_dfs_disconnected.txt";
		Graph g = new AdjSet(graphDoc);
		ConnectComponentCount graphDfsR = new ConnectComponentCount(g);
		System.out.println(graphDfsR.getConnectCompCount());
	}
}
