package greedy;

public class _763_Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int[] last = new int[26];

        // 1. 预处理：记录每个字符最后出现的下标（确定每个字符初始的“最远边界”）
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        // 2. 单层循环探针 i 往后扫（拍平内循环
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, last[s.charAt(i)- 'a']);

            if(i == end){
                result.add(end - start + 1);
                start = i + 1;      // 开启下一个片段
            }
        }
        return result;
    }
}