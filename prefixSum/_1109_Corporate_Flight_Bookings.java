package prefixSum;

public class _1109_Corporate_Flight_Bookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //差分数组，“记录每个位置比前一个位置多了多少（变化量）
        int[] diff = new int[n];

        // 1. 批量记录区间的变化趋势 (O(1))
        for(int[] b : bookings){
            int left = b[0] - 1;
            int right = b[1] - 1;
            int val = b[2];

            diff[left] += val;
            if(right + 1 < n){
                diff[right + 1] -= val; // 离开区间时减去，消除影响
            }
        }

        for(int i = 1; i < n; i++){
            diff[i] += diff[i-1];
        }

        return diff;
    }
}