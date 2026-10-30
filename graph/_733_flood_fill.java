public class _733_flood_fill {
    //图像渲染
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int newColor = color;

        if(oldColor == newColor) return image;

        dfsFromNode(sr, sc, image, oldColor, newColor);
        return image;
    }

    private void dfsFromNode(int r, int c, int[][] image, int oldColor, int newColor){
        int m = image.length;
        int n = image[0].length;
        if (r >= m || r < 0 || c >= n || c < 0 || image[r][c] != oldColor) return;

        image[r][c] = newColor;

        // dfsFromNode(r+1, c, image, oldColor, newColor);
        // dfsFromNode(r-1, c, image, oldColor, newColor);
        // dfsFromNode(r, c+1, image, oldColor, newColor);
        // dfsFromNode(r, c-1, image, oldColor, newColor);

        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};

        for(int[] dir : dirs){
            dfsFromNode(r+dir[0], c+dir[1], image, oldColor, newColor);
        }
    }
}
