public class _85_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == '1'){
                    height[j] += 1; 
                } else {
                    height[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, calculateArea(height));
        }
        return maxArea;
    }

    private int calculateArea(int[] height){
        int n = height.length;

        int[] newHeight = new int[n + 2];
        for (int j = 0; j < height.length; j++){
            newHeight[j + 1] = height[j];
        }

        int[] stack = new int[newHeight.length];
        int top = -1;

        int maxArea = 0;
        for (int i = 0; i < newHeight.length; i++){
            int cur = newHeight[i];

            while(top != -1 && cur < newHeight[stack[top]]){
                int heightIndex = stack[top--];
                int leftIndex = stack[top];
                int rightIndex = i;

                int w = rightIndex - leftIndex - 1;
                int h = newHeight[heightIndex];
                 
                maxArea =Math.max(maxArea, h * w);
            }
            stack[++top] = i;
        }
        return maxArea;
    }
}
