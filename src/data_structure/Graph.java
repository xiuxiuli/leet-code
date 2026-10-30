package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    //dfs 一个连通块
    public static void dfsFromNode(Map<String, List<String>> graph, String start, Set<String> visited) {  
        visited.add(start);
        System.out.println(start);

        for(String neighbor : graph.getOrDefault(start, new ArrayList<>())){
            if (!visited.contains(neighbor)){
                dfsFromNode(graph, neighbor, visited);
            }
        }
    }

    // 所有连通块 : 连通分量（Connected Components）
    public static void dfsEntireGraph(Map<String, List<String>> graph){
        Set<String> visited = new HashSet<>();

        for (String node : graph.keySet()){
            if (!visited.contains(node)){
                dfsFromNode(graph, node, visited);
            }
        }    
    }

    //朋友 = 无向图
    // public static boolean hasCycle_UndirectGraph(){

    // }

    //关注 = 有向图

    public static void main(String args[]){
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("Alice",  new ArrayList<>(Arrays.asList("Bob", "Carol")));
        graph.put("Bob",  new ArrayList<>(Arrays.asList("Alice", "David")));
        graph.put("Carol",  new ArrayList<>(Arrays.asList("Alice")));
        graph.put("David",  new ArrayList<>(Arrays.asList("Bob")));

        Set<String> visited = new HashSet<>();
        dfsFromNode(graph, "Alice", visited);
    }
}