package graph;

import java.util.Collection;

public interface Graph {
	
	int getV();
	
	int getE();
	
	boolean hasEdge(int v, int w);
	
	Collection<Integer> getAdjVertex(int v);
	
	int getDegree(int v);

}
