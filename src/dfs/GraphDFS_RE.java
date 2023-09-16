package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import graph.AdjSet;
import graph.Graph;

/*
 * 递归遍历图（即使它是非连通图）
 * 图的的连通分量=？
 *
 */
public class GraphDFS_RE {
	private Graph g;
	private int[] visited;
	private List<Integer> traversalRes;
	private int connectedCompCount;
	
	
	public GraphDFS_RE(Graph g) {
		this.g = g;
		if (g == null) return;
		
		this.connectedCompCount = 0;
		
		this.visited = new int[g.getV()];
		Arrays.fill(visited, -1);
		
		this.traversalRes = new ArrayList<>();
		
		for (int v = 0; v < g.getV(); v++) {
			if (visited[v] == -1) {
				connectedCompCount += 1;
				dfs(v, connectedCompCount);
			}
		}
	}
	
	private void dfs(int v, int ccId) {
		traversalRes.add(v);
		visited[v] = ccId;
		for (int w : g.getAdjVertex(v)) {
			if (visited[w] == -1) {
				dfs(w, ccId);
			}
		}
	}
	
	public List<Integer> getTraversalRes(){
		return traversalRes;
	}
	
	public int getConnectedCompCount() {
		return connectedCompCount;
	}
	
	public List<Integer>[] getComponents(){
		List<Integer>[] compRes = new ArrayList[connectedCompCount];
		
		for (int i = 0; i < connectedCompCount; i++) {
			compRes[i] = new ArrayList<>();
		}
		for (int v = 0; v < g.getV(); v++) {
			int cc = visited[v];
			compRes[cc - 1].add(v);
		}
		return compRes;
	
	}
	
	public boolean isConnected(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		return visited[v] == visited[w];
	}
	
	private void validateVertex(int v) {
		if (v < 0 || v >= g.getV()) {
			throw new IllegalArgumentException("顶点不合法");
		}
	}
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_dfs_disconnected.txt";
		Graph g = new AdjSet(graphDoc);
		GraphDFS_RE gr = new GraphDFS_RE(g);
		System.out.print(gr.getTraversalRes());
		System.out.print("\n");
		System.out.print(Arrays.toString(gr.getComponents()));
		System.out.print("\n");
		System.out.print(gr.isConnected(0, 4));
	}
}
