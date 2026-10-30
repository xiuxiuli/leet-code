package trie;

public class _212_Word_Search_II {
    class TrieNode{
        private TrieNode[] children;
        private String word;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.word = null;
        } 
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();

        for(String w : words){
            TrieNode cur = root;

            for(int i = 0; i < w.length(); i++){
                char c = w.charAt(i);
                int index = c - 'a';

                if(cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];
            }
            cur.word = w;
        }
        return root;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // 4. DFS + 回溯核心方法
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result){
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#') return;

        char c = board[i][j];
        int index = c - 'a';

        TrieNode next = node.children[index];

        // 剪枝：如果当前字母在前缀树对应的分支里不存在，说明这条路走不通，直接返回
        if(next == null) return;

        // 如果找到了一个单词
        if(next.word != null) {
            result.add(next.word);
            next.word = null; // 【重要优化 1】置空防止重复添加，连 HashSet 去重都省了
        }

        // 标记当前格子已被访问（防止同一次 DFS 里重复使用）
        board[i][j] = '#';

        for(int[] dir : dirs){
            dfs(board, i+dir[0], j+dir[1], next, result);
        }

        // 恢复现场 (Backtracking)
        board[i][j] = c;
    }


    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        List<String> result = new ArrayList<>();

        // 先把 words 全部推入树中
        TrieNode root = buildTrie(words);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
}