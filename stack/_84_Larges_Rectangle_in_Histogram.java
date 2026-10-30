public class _84_Larges_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] newHeight = new int[n + 2];
        for (int j = 0; j < heights.length; j++){
            newHeight[j+1] = heights[j];
        }

        int[] stack = new int[newHeight.length]; //index
        int top = -1;

        int maxArea = 0;

        for (int i = 0; i < newHeight.length; i++){
            int cur = newHeight[i];

            while (top != -1 && cur < newHeight[stack[top]]) {
                int heightIndex = stack[top--];
                int leftIndex = stack[top];
                int rightIndex = i;

                int h = newHeight[heightIndex];
                int w = rightIndex - leftIndex - 1;

                maxArea = Math.max(maxArea, h * w);
            }
            stack[++top] = i;
        }
        return maxArea;
    }
}
