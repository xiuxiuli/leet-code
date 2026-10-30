package graph;

public class _130_Surrounded_Regions {
        // 只要这个区域里有一个 'O' 在边缘上，整个区域就不算被包围

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // 第一步：只从四条边的 'O' 开始 DFS
        // 搭到边的'O'联通到区域都不是‘region’， 不需要改成X
        for(int r = 0; r < m; r++){
            dfs(r, 0, board);   // 左边界
            dfs(r, n-1, board); // 右边界
        }

        for (int c = 0; c < n; c++){
            dfs(0, c, board);   // 上边界
            dfs(m-1, c, board); // 下边界
        }

        // 第二步：遍历整个矩阵
        for(int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (board[r][c] == 'O') board[r][c] = 'X'; // 被包围的
                if (board[r][c] == '#') board[r][c] = 'O'; // 安全的，还原
            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        int m = board.length;
        int n = board[0].length;

        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') return;

        board[r][c] = '#';

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : dirs){
            dfs(r+dir[0], c+dir[1], board);
        }
    }

}