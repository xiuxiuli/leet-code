package graph;

public class _207_Course_Schedule{
    private static Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prereqs){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] prereq : prereqs){
            int course = prereq[1];
            int preCourse = prereq[0];

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++){
            if (dfsFromNode_hasCycle(graph, i, state)) return false;
        }
        return true;
    }  
}