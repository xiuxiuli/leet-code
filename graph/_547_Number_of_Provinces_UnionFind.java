package graph;

class _547_Number_of_Provinces_UnionFind{
     // 并查集结构
    class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
            this.count = n;
        }

        private void union(int i, int j){
            int iParent = find(i);
            int jParent = find(j);

            if(iParent != jParent){
                parent[jParent] = iParent;
                count--;
            }

        }

        private int find(int i) {
            if(parent[i] == i) return i;

            int root = find(parent[i]);

            parent[i] = root;
            return root;
        }

        private int getCount(){
            return count;
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isConnected[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.getCount();
    }
}