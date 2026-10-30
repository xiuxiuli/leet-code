package graph;

public class _721_Accounts_Merge {
    class UnionFind {
        private int[] parent;

        public UnionFind(int size){
            parent = new int[size];

            for(int i = 0; i < size; i++){
                parent[i] = i;
            }
        }

        private void union(int i, int j){
            int iParent = find(i);
            int jParent = find(j);

            if(iParent != jParent){
                parent[iParent] = jParent;
            }
        }

        private int find(int i){
            if(parent[i] == i) return i;

            int root =  find(parent[i]);

            parent[i] = root;
            return root;
        }
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        UnionFind uf = new UnionFind(n);

        // email: i
        Map<String, Integer> emailToAccIdx = new HashMap<>();

        for(int i = 0; i < n; i++){
            List<String> account = accounts.get(i);
            int m = account.size();
            for(int j = 1; j < m; j++){
                String email = account.get(j);

                if(!emailToAccIdx.containsKey(email)){
                    emailToAccIdx.put(email, i);
                } else {
                    uf.union(i, emailToAccIdx.get(email)); //联合i, j
                }
            }
        }

        // 2: 把所有 email 聚拢到它们最终的“大老板账户 ID”下面
        // i : ["email1", "email2",...]
        Map<Integer, List<String>> rootToEmails = new HashMap<>();

        for(String email : emailToAccIdx.keySet()){
            int accIdx = emailToAccIdx.get(email);
            int root = uf.find(accIdx); // 找到大老板账户 ID

            rootToEmails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // 3. 组装最终结果
        List<List<String>> result = new ArrayList<>();
        for(int root : rootToEmails.keySet()){
            List<String> emails = rootToEmails.get(root);

            Collections.sort(emails);  // 题目要求 email 排序

            List<String> mergedAccount = new ArrayList<>();

            // 先放名字，通过大老板 root 账号直接去原数组拿名字
            mergedAccount.add(accounts.get(root).get(0));
            mergedAccount.addAll(emails);

            result.add(mergedAccount);
        }
        return result;
    }
}