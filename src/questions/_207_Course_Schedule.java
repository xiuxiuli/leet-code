package questions;

import java.util.*;

public class _207_Course_Schedule {
    private static Map<Integer, List<Integer>> buildGraph(int[][] prerequisites, int numCourse) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourse; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites){
            int course = pre[0];
            int preCourse = pre[1];

            graph.get(course).add(preCourse);
        }
        return graph;
    }

    private static boolean dfsFromNode_hasCycle(Map<Integer, List<Integer>> graph, int node, int[] state){
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;

        state[node] = 1;
        
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())){
            if (dfsFromNode_hasCycle(graph, neighbor, state)) return true;
        }

        state[node] = 2;
        return false;
    }

    public static boolean canFinish(int numCourse, int[][] prerequisites){
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites, numCourse);

        int[] state = new int[numCourse];

        for(int i = 0; i < numCourse; i++) {
            if (dfsFromNode_hasCycle(graph, i, state)){
                return false;
            }
        }
        return true;
    }
}