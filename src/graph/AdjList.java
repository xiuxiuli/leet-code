package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class AdjList implements Graph {
	private int V;
	private int E;
	private LinkedList<Integer>[] adjList; //链接表
	//private HashSet<Integer>[] adjList;
	//private TreeSet<Integer>[] adjList;
	
	public AdjList(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			String[] arr = line.split(" ");
			this.V = Integer.valueOf(arr[0]);
			this.E = Integer.valueOf(arr[1]);
			
			this.adjList = new LinkedList[V];
			for (int i=0; i < V; i++) {
				adjList[i] = new LinkedList<>();
				//adjList[i] = new HashSet<>();
				//adjList[i] = new TreeSet<>();
			}
			
			while((line = reader.readLine())!= null) {
				arr = line.split(" ");
				int a = Integer.valueOf(arr[0]);
				validateVertex(a);
				int b = Integer.valueOf(arr[1]);
				validateVertex(b);
				
				//检测自环边
				if(a == b) {
					throw new RuntimeException("出现自环边， 错误");
				}		
				//检测平行边
				if(adjList[a].contains(b)) { //O(n)
					throw new RuntimeException("出现平行边， 错误");
				}
				
				adjList[a].add(b);
				adjList[b].add(a);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void validateVertex(int vertex) {
		if (vertex < 0 || vertex >= V) {
			throw new IllegalArgumentException("顶点不符合要求,错误");
		}
	}
	
	@Override
	public int getV() {
		return V;
	}
	
	@Override
	public int getE() {
		return E;
	}
	
	@Override
	//判断两个顶点是否有边
	public boolean hasEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		return adjList[v].contains(w);
	}
	
	@Override
	//获取某个顶点的所有接点
	public List<Integer> getAdjVertex(int v){ 
	//public Collection<Integer> getAllAdjVertex(int v){	//换成hashset
		validateVertex(v);
		return adjList[v];	
	}
	
	@Override
	//获取某个顶点的度数
	public int getDegree(int v) {
		return getAdjVertex(v).size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("顶点数=%d; 边数=%d \n", V, E));
		
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			for (int w : adjList[v]) {
				sb.append(w + ", ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph.txt";
		AdjList adjList =  new AdjList(graphDoc);
		System.out.println(adjList);
	}
}
