package greedy;

public class _56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int curLeft = intervals[0][0];
        int curRight = intervals[0][1];

        for(int i = 0; i < intervals.length; i++){
            int nextLeft = intervals[i][0];
            int nextRight = intervals[i][1];

            // 如果下一个区间的左端点 <= 当前区间的右端点， -> 有重叠，更新现在的右边界
            if(nextLeft <= curRight) {
                curRight = Math.max(curRight, nextRight);
            } else {
                // 如果 nextLeft > curRight -> 出现断层，结算当前区间！
                result.add(new int[]{curLeft, curRight});

                // 切换为下一个新区间作为新的左右边界
                curLeft = nextLeft;
                curRight = nextRight;
            }
        }

        // 把最后一个区间加入结果集
        result.add(new int[]{curLeft, curRight});

        return result.toArray(new int[result.size()][]);
    }
}