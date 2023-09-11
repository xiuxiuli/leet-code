package graph;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//先从graph.tex把图数据读入来， graph.txt中第一行是 x个定点，y条边
//Vertex, Edge

public class AdjMatrix implements Graph{
	// number of vertex, edges
	private int V;
	private int E;
	//准备一个邻接矩阵-二维，用于存放读入的图的顶点和边
	private int[][] adjMatrix; 
	
	public AdjMatrix(String filename) {
		try {
			BufferedReader reader =  new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			String[] arr = line.split(" ");
			this.V = Integer.valueOf(arr[0]);
			this.E = Integer.valueOf(arr[1]);
			
			this.adjMatrix = new int[V][V];
			while((line = reader.readLine()) != null) {
				arr = line.split(" ");
				int a = Integer.valueOf(arr[0]);
				int b = Integer.valueOf(arr[1]);
				validateVertex(a);
				validateVertex(b);
				
				//检测自环边
				if(a == b) {
					throw new RuntimeException("有环， 错误");
				}
				
				//检测平行边
				if (adjMatrix[a][b] == 1) {
					throw new RuntimeException("有平行边，错误");
				}
				
				adjMatrix[a][b] = 1; //ab边
				adjMatrix[b][a] = 1; //ba边 无向无权图
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getV() {
		return V;
	}
	
	public int getE() {
		return E;
	}
	
	@Override
	// 判断两个点之间是否有边
	public boolean hasEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		return adjMatrix[v][w] == 1;
	}
	
	@Override
	// 获取某个点的所有接点
	public List<Integer> getAdjVertex(int v){
		validateVertex(v);
		List<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < V; i++) {
			if (adjMatrix[v][i] == 1) {
				res.add(i);
			}
		}
		return res;
	}
	
	@Override
	//获取某个点的度数(有多少条伸出的边)
	public int getDegree(int v) {
		return getAdjVertex(v).size();
	}
	
	private void validateVertex(int v) {
		if (v < 0 || v >= V) {
			throw new IllegalArgumentException(String.format("顶点%d不合格", v));
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("顶点数=%d, 边数=%d \n", V, E));
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				sb.append(adjMatrix[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		//System.out.println("当前工作目录: " + System.getProperty("user.dir"));
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph.txt";
		AdjMatrix adj =  new AdjMatrix(graphDoc);
		System.out.println(adj);
	}
}
