package dp;

public class _139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将单词列表放入 Set 中，优化查找性能
        Set<String> wordSet = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // 初始状态：空字符串可以被切割
        dp[0] = true;

        // dp[i] 表示 s 的前 i 个字符 s[0...i-1] 是否可以拆分
        for(int i = 1; i <=n; i++){
            for(int j = 0; j < i; j++){
                // 如果前 j 个字符可以拆分，且子串 s[j...i-1] 存在于字典中
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}