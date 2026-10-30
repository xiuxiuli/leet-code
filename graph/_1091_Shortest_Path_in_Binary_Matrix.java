package graph;

public class _1091_Shortest_Path_in_Binary_Matrix{
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        if (n == 1) return 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        grid[0][0] = 1;

        int len = 1;

        int[][] dirs ={
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int k = 0; k < size; k++){
                int[] cur = queue.poll();

                int i = cur[0];
                int j = cur[1];

                if(i == n -1 && j == n-1) return len;

                for(int[] dir : dirs){
                    int ni = i+dir[0];
                    int nj = j+dir[1];

                    if(ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 0){

                        if (ni == n - 1 && nj == n - 1) return len + 1; 

                        queue.offer(new int[]{ni, nj});
                        grid[ni][nj] = 1;
                    }
                }
            }
            len++;
        }
        return -1;
    }
}