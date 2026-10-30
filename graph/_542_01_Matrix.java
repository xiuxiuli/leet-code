package graph;

class _542_01_Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] ans = new int[m][n];

        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) { //等于0的
                    ans[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int i = cur[0];
            int j = cur[1];

            for(int[] dir : dirs){
                int ni = i+dir[0];
                int nj = j+dir[1];

                if(ni >= 0 && ni < m && nj >= 0 && nj < n && ans[ni][nj] == -1) {
                    ans[ni][nj] = ans[i][j] + 1;
                    queue.offer(new int[]{ni,nj});
                }
            }
        }
        return ans;
    }
}