package array;

public class _54_Spiral_Matrix {
    //按“上 → 右 → 下 → 左”顺时针的方向一圈圈往里走，
    //而控制这一圈圈收缩的关键，是通过维护四个边界指针（top, bottom, left, right）
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        if(matrix == null || m == 0) return result;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while(top <= bottom && left <= right){
            // 1. 从左到右遍历上边界
            for(int j = left; j <= right; j++){
                result.add(matrix[top][j]);
            }
            top++; // 上边界下移

            // 2. 从上到下遍历右边界
            for(int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--; // 右边界左移

            // 3. 从右到左遍历下边界 (注意检查 top <= bottom)
            if(top <= bottom) {
                for(int j = right; j >= left; j--){
                    result.add(matrix[bottom][j]);
                }
                bottom--;// 下边界上移
            }

            // 4. 从下到上遍历左边界 (注意检查 left <= right)

            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // 左边界右移
            }
        }
        return result;
    }
}