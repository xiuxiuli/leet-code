package questions;

import java.util.*;

public class _210_Course_Schedule_II_Kahn {

    // outdegree 从这个点出去多少条边
    // indegree 有多少条边指向这个点
    public int[] findOrder(int numCourses, int[][] prerequisities) {
        // Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++){
            //graph.put(i, new ArrayList<>()); //修完 b 课，接下来有资格修 [A, C, B, D]
            graph[i] = new ArrayList<>();
        }

        int[] indeg = new int[numCourses]; //课程 i 还有多少个prerequisite课程。有多少前提课的箭头射向这个课程
        
        for (int[] preq : prerequisities) {
            int course = preq[0];
            int preCourse = preq[1];
            // graph.get(preCourse).add(course);
            graph[preCourse].add(course);

            indeg[course]++;
        }

        //Queue<Integer> q = new LinkedList<>();
        Deque<Integer> q = new ArrayDeque<>();
  
        for(int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i); //入度为0. 就是这个课程没有任何 prerequisite。 这课程可以先学
        }

        int[] order = new int[numCourses]; 
        int idx = 0;

        while (!q.isEmpty()){
            int node = q.poll(); // 取出一个课程
            order[idx++] = node;

            //for (int neighbor : graph.get(node)){
            for (int neighbor : graph[node]){
                indeg[neighbor]--; 
                if (indeg[neighbor] == 0) q.offer(neighbor);
            }   
        }
        if (idx != numCourses) return new int[0]; 
        return order;
    }
}