package graph;

public class _433_Minimum_Genetic_Mutation{
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if(!bankSet.contains(endGene)){
            return -1;
        }

        if(startGene.equals(endGene)){
            return 0;
        }

        // 2. 双向 BFS：创建两个集合，分别从起点和终点同时扩散
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        startSet.add(startGene);
        endSet.add(endGene);

        bankSet.remove(startGene);
        bankSet.remove(endGene);

        int step = 0;
        char[] geneChars = {'A', 'C', 'G', 'T'};

        // 3. 开始双向 BFS 循环
        while(!startSet.isEmpty() && !endSet.isEmpty()){
            step++;

            // 【核心优化】：总是挑选较小的集合进行扩散，让搜索树的规模最小
            if(startSet.size() > endSet.size()){
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }

            // 用来保存当前层扩散出来的下一层新基因
            Set<String> nextSet = new HashSet<>();

            for(String cur : startSet){
                char[] charArray = cur.toCharArray();

                for (int i = 0; i < 8; i++){
                    char oldChar =  charArray[i];

                    for(char c : geneChars){
                        if (c == oldChar) continue;

                        charArray[i] = c;
                        String nextGene = new String(charArray);

                        // 如果在对面的集合里找到了，说明两头接通了！直接返回总步数
                        if(endSet.contains(nextGene)){
                            return step;
                        }

                        // 如果在 bank 里，说明是一次合法合规的突变
                        if(bankSet.contains(nextGene)){
                            nextSet.add(nextGene);
                            bankSet.remove(nextGene);// 立即移除，防止重复访问
                        }
                    }
                    charArray[i] = oldChar; // 恢复现场
                }
            }
            // 把下一层变成当前层，继续下一轮扩散
            startSet = nextSet;
        }
        return -1; // 两头无法相遇，说明没有通路
}