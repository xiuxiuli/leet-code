package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graph.AdjSet;
import graph.Graph;

public class GraphDFS {
	private Graph g;
	private List<Integer> res;
	private boolean visited[];
	
	public GraphDFS(Graph g) {
		this.g = g;
		if (g == null) return;
		this.res = new ArrayList<>();
		this.visited = new boolean[g.getV()];
		
		//因为存在disconnected graph非连通图, 所以指定从某个顶点遍历的话
		//对这种断开图是不会完整遍历的，因此图的遍历不应该指定某个顶点进行
		//而是把全部的顶点都放进去遍历
		for (int v = 0; v < g.getV(); v++) {
			if (!visited[v]) {
				dfs(v);
			}
		}
	}
	
	private void dfs(int v){
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		
		//标记某些接点已经push入栈，visited
		visited[v] = true;
		
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			res.add(curr);
			for (int w : g.getAdjVertex(curr)) {
				if (!visited[w]) {
					stack.push(w);
					visited[w] = true;
				}
			}
		}
	}
	
	public List<Integer> getRes(){
		return res;
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_dfs_disconnected.txt";
		Graph g = new AdjSet(graphDoc);
		GraphDFS graphDfs = new GraphDFS(g);
		System.out.print(graphDfs.getRes());
	}
}
