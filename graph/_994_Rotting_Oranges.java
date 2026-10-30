package graph;

public class _994_Rotting_Oranges{
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int freshCount = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[][]{i, j});
                } else if(grid[i][j] == 1){ 
                    freshCount++;
                }
            }
        }

        if(freshCount == 0) return 0;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int minute = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            boolean rottenInThisRound = false;

            for (int i = 0; i < size; i++){
                int[] cur = queue.poll();
                for(int[] dir : dirs){
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                        rotthenInThisRound++;
                    }
                }
            }
            if(rottenInthisCount) minute++;
        }
        return freshCount == 0? minutes : -1;
    }
}