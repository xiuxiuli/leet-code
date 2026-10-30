package array;

public class _48_Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. 转置矩阵 (主对角线 swap)
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 左右翻转每一行
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}