package graph;


class _684_Redundant_Connection {
    class UnionFind{
        private int[] parent;

        public UnionFind(int size){
            parent = new int[size];
            for(int i = 0; i < size; i++){
                parent[i] = i;
            }
        }

        private boolean union(int i, int j){
            int iParent = find(i);
            int jParent = find(j);
            
            if(iParent != jParent){
                parent[iParent] = jParent;
                return true; // 成功合并，之前没环
            }
            return false;
        }

        private int find(int i){
            if(parent[i] == i) return i;

            int root = find(parent[i]);
            parent[i] = root;
            return root;
        }     
    }


    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        UnionFind uf = new UnionFind(n+1);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            // 如果合并失败，说明这两个点早就连通了，当前边就是导致“环”的冗余边
            if(!uf.union(u, v)){
                return edge;
            }
        }
        return new int[0];
    }
}