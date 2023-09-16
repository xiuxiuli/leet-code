package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import graph.AdjSet;
import graph.Graph;

//递归遍历图
public class DisconGraphVertex {
	private Graph g;
	private int ConnectCompCount;
	private int visited[];
	
	public DisconGraphVertex(Graph g) {
		this.g = g;
		if (g == null) return;
		
		this.ConnectCompCount = 0;
		
		this.visited = new int[g.getV()];
		Arrays.fill(visited, -1);
		
		for (int v = 0; v < g.getV(); v++) {
			if (visited[v] == -1) {
				ConnectCompCount++;
				dfs(v, ConnectCompCount);
			}
		}
	}
		
	private void dfs(int v, int ccId) {
		visited[v] = ccId;
		for (int w : g.getAdjVertex(v)) {
			if (visited[w] == -1)
				dfs(w, ccId);
		}
	}

	public int getConnectCompCount() {
		return ConnectCompCount;
	}
	
	public List<Integer>[] components(){
		List<Integer>[] res= new ArrayList[ConnectCompCount];
//		Arrays.fill(res, new ArrayList[ConnectCompCount]);
		for(int i = 0; i < ConnectCompCount; i++) {
			res[i] = new ArrayList<>();
		}
		for (int v = 0; v < g.getV(); v++) {
			int cc = visited[v];
			res[cc-1].add(v);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_dfs_disconnected.txt";
		Graph g = new AdjSet(graphDoc);
		DisconGraphVertex graphDfsR = new DisconGraphVertex(g);
		System.out.println(graphDfsR.getConnectCompCount());
	}
}
