package trie;

public class _208_Implement_Trie {
    class Trie {

        // 一个 TrieNode 里面存的 children 数组就是某单词连续的字母指针
        private class TrieNode{
            TrieNode[] children;
            boolean isEnd;

            public TrieNode(){
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }
        
        /** 插入一个单词到前缀树中 */
        public void insert(String word) {
            // 指针指向ROOT， ROOT不存字母，它是一个指针数组，26个坑
            TrieNode node = root;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                int index = c - 'a'; // 计算字符在数组中的索引位置

                // 如果该路径不存在，则创建一个新的子节点
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }

                //指针向下跳一步（下一个字母的指针）
                node = node.children[index];
            }
            node.isEnd = true;
        }
        
        /** 查找单词 word 是否在前缀树中（必须是完整单词） */
        public boolean search(String word) {
            TrieNode node = root;

            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(node.children[index] == null) return false;

                node = node.children[index];
            }
            return node.isEnd;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(int i = 0; i < prefix.length(); i++){
                int index = prefix.charAt(i) - 'a';
                if (node.children[index] == null) return false;
                node = node.children[index];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}