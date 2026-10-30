package array;

public class _73_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
    

        // 1. 检查第一行是否有 0
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        //  检查第一列是否有 0
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // 2. 用第一行和第一列记录其余元素的 0 标记
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. 根据第一行和第一列的标记，更新第 1~m-1 行和第 1~n-1 列的标记
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 4. 根据第一行和第一列的标记更新其余区域
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            } 
        }

        // 5. 最后根据独立标记，单独处理第一行和第一列
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(firstColHasZero){
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}