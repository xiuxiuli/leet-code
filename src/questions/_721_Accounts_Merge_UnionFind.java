package questions;

import java.util.*;

public class _721_Accounts_Merge_UnionFind {
    class UnionFind {
        Map<String, String> parent = new HashMap<>(); //child_email  -> parent_email
        // a → b → c → d

        public void add(String x) {
            parent.putIfAbsent(x, x);
        }

        // 如果 x 不是 root
        //    就继续找它父节点的 root
        //    并把 x 直接挂到 root 上
        // 最后返回 root
        // 路径压缩
        // a → d
        // b → d
        // c → d
        public String find(String x) {
            if(!parent.get(x).equals(x)) { //parent.get(x) 找到X的父节点
                parent.put(x, find(parent.get(x))); 
            }
            return parent.get(x);
        }

        public void union(String x, String y){
            String rootX = find(x);
            String rootY = find(y);

            if (!rootX.equals(rootY)){
                parent.put(rootX, rootY);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();

        Map<String, String> emailToName = new HashMap<>();

        // Step1: union emails in the same account
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            uf.add(firstEmail);
            emailToName.put(firstEmail, name);

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);

                uf.add(email);
                uf.union(firstEmail, email);
                
                emailToName.put(email, name);

            }
        }

        // Step2: group emails by root
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : emailToName.keySet()){
            String root = uf.find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step3: build result
        List<List<String>> result = new ArrayList<>();

        for (List<String> group : groups.values()) {
            Collections.sort(group);

            String name = emailToName.get(group.get(0));

            List<String> merged = new ArrayList<>();

            merged.add(name);
            merged.addAll(group);

            result.add(merged);
        }
        return result;
    }

}