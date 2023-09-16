package graph;

public class CycleDetect {
	private Graph g;
	
	private boolean[] visited;
	private int[] prevs;
	
	private boolean hasCycle = false;
	
	public CycleDetect(Graph g) {
		this.g = g;
		
		this.visited = new boolean[g.getV()];
		
		for (int v = 0; v < g.getV(); v++) {
			if(!visited[v]) {
				if (dfs(v, v)) {
					hasCycle = true;
					break;
				}
			}
		}
		this.prevs = new int[g.getV()];
		
	}
	
	private boolean dfs(int v, int prev) {
		visited[v] = true;
		for (int w : g.getAdjVertex(v)) {
			if(!visited[w]) {
				if(dfs(w, v)) return true;
			} else {
				if (w != prev) {
					return true;
				}
			}
		
		}
		return false;
	}
	
	private boolean hasCycle() {
		return hasCycle;
	}
	

}
