package greedy;

public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
    
        int arrow = 1;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int minRight = points[0][1];

        for(int i = 1; i < points.length; i++){
            int curLeft = points[i][0];
            int curRight = points[i][1];
            if(curLeft > minRight){
                arrow++;
                minRight = curRight;
            }
        }
        return arrow;
    }
}