package questions;

import java.util.*;

public class _210_Course_Schedule_II_Dfs {

    private static Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisities){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] preq : prerequisities) {
            int course = preq[0];
            int preCourse = preq[1];

            graph.get(course).add(preCourse);
        }
        return graph;
    }

    // DFS Topological Sort - 拓扑排序
    // 
    private static boolean dfsFromNode_hasCircle(Map<Integer, List<Integer>> graph, int node, int[] state, List<Integer> postOrder){
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;

        state[node] = 1;

        for (int neighbor : graph.get(node)){
            if (dfsFromNode_hasCircle(graph, neighbor, state, postOrder)) return true;
        }
        state[node] = 2;
        postOrder.add(node);

        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisities) {
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisities);

        int[] state = new int[numCourses];
        
        List<Integer> postOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            if(dfsFromNode_hasCircle(graph, i, state, postOrder)) return new int[0];
        }
        Collections.reverse(postOrder);

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = postOrder.get(i);
        }
        return order;
    }
}
