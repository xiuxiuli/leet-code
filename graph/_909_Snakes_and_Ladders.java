package graph;

public class _909_Snakes_and_Ladders{
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        int target = n*n;

        // 1. 特判：起点和终点重合
        if(target == 1) return 0;

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[target + 1];

        // 初始化起点 1
        queue.offer(1);
        visited[1] = true;

        int steps = 0;

        // 2. 标准 BFS 队列扩散
        while(!queue.isEmpty()){
            int size =  queue.size();

            for(int k = 0; k < size; k++){
                int cur = queue.poll();

                // 模拟掷骰子 1 ~ 6 点
                for(int dice = 1; dice <= 6; dice++){
                    int next = cur + dice;
                    if(next > target) break;// 超出棋盘，直接无视

                    // 获取当前位置的矩阵坐标
                    int[] pos = getCoordinates(next, n);
                    int r = pos[0];
                    int c = pos[1];

                    int destination = board[r][c] == -1? next : board[r][c];

                    // 💥 超前检查：如果这个目的地刚好是终点，直接返回当前步数 + 1
                    if(destination == target){
                        return steps + 1;
                    }

                    // 如果没访问过，投入队列，标记为已访问
                    if(!visited[destination]){
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            steps++;// 这一层的所有格子（回合）都走完了，步数才加 1
        }   
        return -1; // 无法到达终点
    }

    // 🛠️ 辅助函数：将编号 (1 ~ n^2) 转换为矩阵坐标 [row, col]
    private int[] getCoordinates(int cur, int n){
        int r = (n - 1) - (cur - 1)/n;
        int c = (cur - 1) % n;

        // 如果距离底部的行数是奇数，说明是从右往左折返走
        if((n-1-r)%2 == 1){
            c = (n -1) - c;
        }
        return new int[]{r,c};
    }

}