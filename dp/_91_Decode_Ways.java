package dp;

public class _91_Decode_Ways {
    // p, q, cur
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int p = 1;  // dp[i-2]
        int q = 1;  // dp[i-1]

        for(int i = 1; i < s.length(); i++){
            int cur = 0;

            // 1.尝试作为单数字解码（只要当前字符不是 '0'，就能独立继承前一步的所有可能）
            if(s.charAt(i) != '0') {
                cur += q;
            }

            // 2. 尝试与前一个数字组合成双数字解码
            int twoDigits = Integer.parseInt(s.substring(i-1, i+1));
            if(twoDigits >= 10 && twoDigits <= 26){
                cur += p;
            }

            // 如果既不能单独解码，也不能和前面组合，说明遇到了无效编码(如 "30" 或 "00")
            if(cur == 0) return 0;

            // 滚动更新状态
            p = q; 
            q = cur;
        }
        return q;
    }
}