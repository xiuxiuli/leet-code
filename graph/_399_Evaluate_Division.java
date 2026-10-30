package graph;

public class _399_Evaluate_Division {
    private class UnionFind{
        private int[] parent;
        private double[] weight; // 记录自己是父亲的多少倍

        public UnionFind(int size){
            parent = new int[size];
            weight = new double[size];

            for(int i = 0; i < size; i++){
                parent[i] = i;
                weight[i] = 1.0;
            }
        }

        private int find(int i){
            if(parent[i] == i) return i;

            int originParent = parent[i];
            int root = find(originParent);

            // 路径压缩时，同步乘上老爸到大老板的倍数
            parent[i] = root;
            weight[i] = weight[i] * weight[originParent];

            return root;
        }

        private void union(int i, int j, double v){
            int iParent = find(i);
            int jParent = find(j);

            if(iParent != jParent){
                parent[iParent] = jParent;
                weight[iParent] = (weight[j] * v) / weight[i];
            }
        }

        private double isConnected(int i, int j){
            int iParent = find(i);
            int jParent = find(j);

            if(iParent == jParent){
                return weight[i] / weight[j];
            }
            return -1.0;
        }
    }

    public double[] calcEquation(
        List<List<String>> equations, 
        double[] values, 
        List<List<String>> queries) {
            
        // 1. 整理eqautions里的字符串，给它们编号. 例， "a": 0， "b": 1
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for(List<String> eq : equations){
            for(String var : eq){
                if(!map.containsKey(var)){
                    map.put(var, id++);
                }
            }
        }

        // 2. 把equations和values存入UnionFind带权并查集里
        // equations 是vars, values是结果
        UnionFind uf = new UnionFind(id);
        for(int i = 0; i < equations.size(); i++){
            int u = map.get(equations.get(i).get(0)); // 例"a": 1 中的1
            int v = map.get(equations.get(i).get(1)); // 例"b": 1 中的2

            uf.union(u, v, values[i]); 
        }

        // 3. 处理查询
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            if(!map.containsKey(var1) || !map.containsKey(var2)) {
                result[i] = -1.0;
            } else {
                int u = map.get(var1);
                int v = map.get(var2);
                result[i] = uf.isConnected(u, v);
            }
        }
        return result;
    }
}