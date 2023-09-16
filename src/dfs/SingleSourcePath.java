package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import graph.AdjSet;
import graph.Graph;

//单源路径, 给一个图和一个顶点，求出这个顶点的所有路径
public class SingleSourcePath {
	private Graph g;
	private int source;
	
	private boolean[] visited;
	//储存每一个顶点的前一个顶点，初始化为-1
	private int[] prevs;
	
	public SingleSourcePath(Graph g, int source) {
		this.g = g;
		
		this.visited = new boolean[g.getV()];
		
		this.prevs = new int[g.getV()];
		Arrays.fill(prevs, -1);
		
		//深度优先遍历，从指定的源点出发
		//源顶点的前一个顶点设置为顶点本身
		dfs(source, source);
	}
	
	//递归遍历顶点v， 并维护顶点v的前一个顶点的信息
	private void dfs(int v, int prev) {
		visited[v] = true;
		//维护v的前一个顶点
		prevs[v] = prev;
		for (int w : g.getAdjVertex(v)) {
			if (!visited[w]) {
				dfs(w, v);
			}
		}
	}
	
	public boolean isConnected(int target) {
		validateVertex(target);
		return visited[target];
	}
	
	private void validateVertex(int v) {
		if (v < 0 || v >= g.getV()) {
			throw new IllegalArgumentException("顶点不合格");
		}
	}
	
	public List<Integer> path(int target){
		List<Integer> res = new ArrayList<>();
		
		if (!isConnected(target)) return res;
		
		//根据prevs的信息找到路径
		while (target != source) {
			res.add(target);
			target = prevs[target];
		}
		res.add(source);
		
		//翻转
		Collections.reverse(res);
		return res;
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_singleSource.txt";
		Graph g = new AdjSet(graphDoc);
		SingleSourcePath sp = new SingleSourcePath(g, 0);
		System.out.print(sp.path(6));
	}
}
