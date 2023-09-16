package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dfs.SingleSourcePath;

public class TwoVertexPath {
	private Graph g;
	private int source;
	private int target;
	
	private boolean[] visited;
	private int[] prevs;
	
	private List<Integer> res;
	
	public TwoVertexPath(Graph g, int source, int target) {
		this.g = g;
		this.source = source;
		this.target = target;
		this.visited =  new boolean[g.getV()];
		this.prevs = new int[g.getV()];
		Arrays.fill(prevs, -1);
		
		dfs(source, source);
		this.res = new ArrayList<>();
	}
	
	private void validateVertex(int v) {
		if (v < 0 || v >= g.getV()) {
			throw new IllegalArgumentException("非法顶点");
		}
	}
	
	private boolean isConnected() {
		validateVertex(target);
		return visited[target];
	}
	
	private boolean dfs(int v, int prev) {
		visited[v] = true;
		prevs[v] = prev;
		if (v == target) return true;
		for (int w : g.getAdjVertex(v)) {
			if (!visited[w]) {
				if (dfs(w, v)) return true;
			}
		}
		return false;
	}
	
	private List<Integer> path(){
		if (!isConnected()) return res;
		
		int temp = target;
		while (temp != source) {
			res.add(temp);
			temp = prevs[temp];
		}
		res.add(source);
		Collections.reverse(res);
		return res;
	}
	
	public List<Integer> getRes(){
		return res;
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_singleSource.txt";
		Graph g = new AdjSet(graphDoc);
		TwoVertexPath path = new TwoVertexPath(g, 0, 4);
		System.out.print(path.path());
	}
	
	

}
