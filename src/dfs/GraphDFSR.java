package dfs;

import java.util.ArrayList;
import java.util.List;

import graph.AdjSet;
import graph.Graph;

//递归遍历图
public class GraphDFSR {
	private Graph g;
	
	public GraphDFSR(Graph g) {
		this.g = g;
	}
	
	public List<Integer> dfs(int v){
		ArrayList<Integer> res = new ArrayList<>();
		if (g == null) return res;
		boolean visited[] = new boolean[g.getV()];
		dfs(v, res, visited);
		return res;
	}
	
	private void dfs(int v, List<Integer> res, boolean[] visited) {
		res.add(v);
		visited[v] = true;
		for (int w : g.getAdjVertex(v)) {
			dfs(w, res, visited);
		}
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_dfs.txt";
		Graph g = new AdjSet(graphDoc);
		GraphDFSR graphDfsR = new GraphDFSR(g);
		System.out.println(graphDfsR.dfs(0));
	}
}
