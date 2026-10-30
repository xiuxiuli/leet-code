package questions;

import java.util.*;

public class _721_Accounts_Merge_Dfs {
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // build graph
        // graph 里面: 
        // { 节点, 邻居列表 []}
        // { firstEmail [neighbor emails 2, 3, 4....] }
        // { secEmail, [neighbor emails 1, 3, 4....] }
        // emailToName: [  [abc@gmail.com, John], [efg@gmail.com, John],....]
        for (List<String> account : accounts){
            // 先录入第一个Email
            String name = account.get(0);
            String firstEmail = account.get(1);

            graph.putIfAbsent(firstEmail, new ArrayList<>());

            emailToName.put(firstEmail, name);

            // 录入其他
            for (int i = 2; i < account.size(); i++){
                String email = account.get(i);

                graph.putIfAbsent(email, new ArrayList<>());
                emailToName.put(email, name);

                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }

        // 2. Find connected components
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (String email : graph.keySet()) {
            if (visited.contains(email)) continue;

            List<String> component = new ArrayList<>();
            dfs(graph, email, visited, component);

            Collections.sort(component);
            component.add(0, emailToName.get(email));
            result.add(component);
        }
        return result;
    }

    private void dfs(
        Map<String, List<String>> graph,
        String email, 
        Set<String> visited,
        List<String> component
    ) {
        visited.add(email);
        component.add(email);

        for (String neighbor : graph.get(email)){
            if (!visited.contains(neighbor)){
                dfs(graph, neighbor, visited, component);
            }
        }
    }
}
