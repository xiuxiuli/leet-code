package questions;
import java.util.Queue;
import java.util.LinkedList;

public class _200_Number_Of_Islands{
    private void bfs(char[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        grid[r][c] = '0';

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            int[][] directions = {
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
            };

            for (int[] dir : directions){
                int neighborR = row + dir[0];
                int neighborC = col + dir[1];

                if (neighborR >= 0 && neighborR < m &&
                    neighborC >=0 && neighborC < n &&
                    grid[neighborR][neighborC] == '1'
                ){
                    queue.offer(new int[]{neighborR, neighborC});
                    grid[neighborR][neighborC] = '0';
                }
            }
        }
    }

    private void dfsFromNode(char[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >=m ||c < 0 || c >= n || grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfsFromNode(grid, r+1, c);
        dfsFromNode(grid, r-1, c);
        dfsFromNode(grid, r, c+1);
        dfsFromNode(grid, r, c-1);
    }

    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1'){
                    count++;
                    dfsFromNode(grid, r, c);
                }      
            }
        }
        return count;
    }

    public static void main(String args[]){
        char[][] grid = new char[][] {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        _200_Number_Of_Islands solution = new _200_Number_Of_Islands();
        int result = solution.numIslands(grid);
        System.out.println(result);
    }
}