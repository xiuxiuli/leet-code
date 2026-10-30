package backtracking;

public class _79_Word_Search {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // 剪枝 1：单词长度超过网格总格数，直接不可能
        if (word.length() > m * n) return false;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        int m = board.length;
        int n = board[0].length;

        // 1. 终止条件
        if(index == word.length())return true;

        // 2. 边界/字符匹配判断
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) return false;

        // 3. 标记访问 (做选择)
        char c = board[i][j];
        board[i][j] = '#';  // 标记已使用

        for(int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];

            // 只要有一个方向找到了，就提前返回 true (剪枝)
            if(backtrack(board, word, nextI, nextJ, index + 1)) {
                board[i][j] = c;    // 记得在 return 前恢复现场！
                return true;
            }
        }

        board[i][j] = c;
        return false;
    }
}