package hashmap;

public class _36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for(int r = 0; r < 9; r++){
            for( int c = 0; c < 9; c++){
                char ch = board[r][c];
                if(ch == '.') continue;

                int val = ch - '0';
                int mask = 1 << val;
                int boxIndex = (r / 3) * 3 + (c / 3);

                // 检查行、列、3x3 宫格内是否已经出现过该数字
                if((rows[r] & mask) != 0 ||
                    (cols[c] & mask) != 0 ||
                    (boxes[boxIndex] & mask) != 0
                ) {
                    return false; //出现过
                }

                //标记已访问
                rows[r] |= mask;
                cols[c] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true;
    }


    public boolean isValidSudoku_2(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++){
                char ch = board[r][c];
                if(ch == '.') continue;

                // 分别构造行、列、九宫格的唯一字符串标识
                String inRow = ch + " in row " + r;
                String inCol = ch + " in col " + c;
                String inBox = ch + " in box " + (r / 3)  + "-" + (c /3);

                // 如果任何一个已经存在，说明重复
                if (!set.add(inRow) || !set.add(inCol) || !set.add(inBox)){
                    return false;
                }
            }
        }
        return true;
    }
}