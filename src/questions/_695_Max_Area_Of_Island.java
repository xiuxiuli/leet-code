package questions;

public class _695_Max_Area_Of_Island {
    private int dfsFromNode(int[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 ||r >= m || c < 0 || c>=n || grid[r][c] == 0) return 0;
        grid[r][c] = 0;

        int area = 1;

        area += dfsFromNode(grid, r+1, c);
        area += dfsFromNode(grid, r-1, c);
        area += dfsFromNode(grid, r, c+1);
        area += dfsFromNode(grid, r, c-1);
        
        return area;
    }

    public int maxAreaOfIsland(int[][] grid){
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
    
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 1){
                    int curArea = dfsFromNode(grid, r, c);
                    maxArea = Math.max(curArea, maxArea);
                }
            }
        }
        return maxArea;
    }
}