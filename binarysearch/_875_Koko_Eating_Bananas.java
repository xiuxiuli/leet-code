package binarysearch;

public class _875_Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left < right) {
            int mid = left + (right - left) /2;

            if(canFinish(piles, mid, h)){
                right = mid; // 当前速度可行，尝试更小的速度
            } else {
                left = mid + 1; // 超时，需要更快的速度
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h){
        long totalHours = 0;
        for(int pile : piles){
            totalHours += (pile + speed - 1)/ speed; //// 向上取整等价于 (pile + speed - 1) / speed
        }
        return totalHours <= h;
    }
}