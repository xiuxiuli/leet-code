package graph;

public class _207_Course_Schedule_bfs{

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree= new int[numCourses];

        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i< numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] prereq :  prerequisites){
            int course = prereq[0];
            int preCourse = prereq[1];

            graph[preCourse].add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int count = 0;

        while (!q.isEmpty()){
            int cur = q.poll();
            count++;

            for(int neighbor : graph[cur]){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}
