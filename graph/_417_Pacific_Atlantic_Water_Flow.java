package graph;

public class _417_Pacific_Atlantic_Water_Flow {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> result = new ArrayList<>();

            int m = heights.length; // rows
            int n = heights[0].length; //cols

            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];

            // 1. 从左右边界开始 DFS
            for(int i = 0; i < m; i++){
                dfs(i, 0, heights, pacific, heights[i][0]); // 左边（太平洋）
                dfs(i, n - 1,heights, atlantic, heights[i][n-1]); // 右边（大西洋）
            }

            // 2. 从上下边界开始 DFS
            for(int i = 0; i < n; i++){
                dfs(0, i,  heights, pacific, heights[0][i]);  // 上边（太平洋）
                dfs(m-1, i, heights, atlantic, heights[m-1][i] );   // 下边（大西洋）
            }

            // 3. 找出重合的点
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(pacific[i][j] && atlantic[i][j]){
                        result.add(Arrays.asList(i, j));
                    }
                }
            }
            return result;
        }

        private void dfs(int r, int c, int[][] heights, boolean[][] visited, int prevHeight){
            int m = heights.length;
            int n = heights[0].length;

            if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) return;

            visited[r][c] = true;

            dfs(r+1, c, heights, visited, heights[r][c]);
            dfs(r-1, c, heights, visited, heights[r][c]);
            dfs(r, c+1, heights, visited, heights[r][c]);
            dfs(r, c-1, heights, visited, heights[r][c]);
        }
}