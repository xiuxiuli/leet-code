package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graph.AdjSet;
import graph.Graph;

public class GraphDFS {
	private Graph g;
	
	public GraphDFS(Graph g) {
		this.g = g;
	}
	
	public List<Integer> dfs(int v){
		ArrayList<Integer> res = new ArrayList<>();
		if (g == null) return res;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		
		//标记某些接点已经push入栈，visited
		boolean[] visited =  new boolean[g.getV()];
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
		return res;
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_dfs.txt";
		Graph g = new AdjSet(graphDoc);
		GraphDFS graphDfs = new GraphDFS(g);
		System.out.print(graphDfs.dfs(0));
	}
}
