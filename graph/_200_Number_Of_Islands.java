
public class _200_Number_Of_Islands {
    private void dfsFromNode(char[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') return;
        grid[r][c] = '0';

        dfsFromNode(grid, r-1, c);
        dfsFromNode(grid, r+1, c);
        dfsFromNode(grid, r, c-1);
        dfsFromNode(grid, r, c+1);
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if (grid[r][c] == '1'){
                    count++;
                    dfsFromNode(grid, r, c);
                }
            }
        }
        return count; 
    }
}