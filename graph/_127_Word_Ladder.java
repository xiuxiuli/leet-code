package graph;

public class _127_Word_Ladder{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if (beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            step++;
            Set<String> nextSet = new HashSet<>();

            for(String word : beginSet){
                char[] charArray = word.toCharArray();

                for(int i = 0; i < charArray.length; i++){
                    char oldChar = charArray[i];

                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == oldChar) continue;

                        charArray[i] = c;
                        String nextWord = new String(charArray);

                        if(endSet.contains(nextWord)) return step;

                        if(wordSet.contains(nextWord)) {
                            nextSet.add(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    charArray[i] = oldChar;
                }
            }
            beginSet = nextSet;
        }
        return 0;
    }
}