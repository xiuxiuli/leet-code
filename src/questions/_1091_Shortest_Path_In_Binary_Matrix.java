package questions;

import java.util.*;

public class _1091_Shortest_Path_In_Binary_Matrix {

    public int shortestPathBinaryMatrix(int[][] grid){
        int n = grid.length;
        
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if (n == 1) return 1;
        
        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        grid[0][0] = 1; // mark visited
        int pathLen = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];

                if (r == n -1 && c == n-1) return pathLen;

                for (int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                    if (grid[nr][nc] != 0) continue;

                    grid[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
            pathLen++;
        }
        return -1;
    }
}