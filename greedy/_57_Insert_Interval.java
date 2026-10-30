package greedy;

public class _57_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int left = newInterval[0];
        int right = newInterval[1];

        boolean inserted = false;

        for(int[] interval : intervals){
            int curLeft = interval[0];
            int curRight = interval[1];

            // 1. cur区间完全在 newInterval 左侧（无重叠）
            if(curRight < left) {
                result.add(interval);
            } 
            // 2. cur区间完全在 newInterval 右侧（无重叠）
            else if( right < curLeft){
                if(!inserted){
                    result.add(new int[]{left, right});
                    inserted = true;
                }
                result.add(interval);
            } 
            // 3. 有重叠！更新吞并后的 left 和 right 边界
            else {
                left = Math.min(left, curLeft);
                right = Math.max(right, curRight);
            }
        }

        // 如果 newInterval 比所有区间都大，最后补上结算
        if(!inserted){
            result.add(new int[]{left, right});
        }
        return result.toArray(new int[result.size()][]);
    }
}