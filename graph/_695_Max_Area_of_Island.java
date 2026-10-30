package graph;

public class _695_Max_Area_of_Island {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;

        for(int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(r, c, grid));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int r, int c, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) return 0;

        int curArea = 1;
        grid[r][c] = 0;

        curArea += dfs(r + 1, c, grid);
        curArea += dfs(r - 1, c, grid);
        curArea += dfs(r, c + 1, grid);
        curArea += dfs(r, c - 1, grid);
        
        return curArea;
    }
}