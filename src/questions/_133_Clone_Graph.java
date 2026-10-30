package questions;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors){
        val = _val;
        neighbors = _neighbors;
    }
}

public class _133_Clone_Graph {
    private Map<Node, Node> oldToNew = new HashMap<>();

    public Node cloneGraph_DFS(Node node) {
        if (node == null) return null;

        // 1. 如果映射表裡已經有了，說明這個節點已經被克隆過（即 visited）
        if(oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        // 2. 創建克隆節點（只複製值，不複製鄰居）
        Node clone = new Node(node.val);

        // 3. 立即放入映射表，這一步是防止「環」導致死循環的關鍵
        oldToNew.put(node, clone);

        // 4. 遞歸處理鄰居
        for (Node neighbor : node.neighbors){
            // 這裡傳入的是原鄰居，add 的是 cloneGraph 返回的克隆鄰居
            clone.neighbors.add(cloneGraph_DFS(neighbor));
        }
        return clone;
    }

    public Node cloneGraph_BFS(Node node) {
        if (node == null) return null;

        // 1. 账本：Map<旧节点, 新节点>
        Map<Node, Node> visited = new HashMap<>();

        // 2. 初始化：克隆起点并放入 Map，然后入队
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        //
        Queue<Node> q = new LinkedList<>();
        q.offer(node); // 注意：队列里放的是“旧节点”，用来探路

        while (!q.isEmpty()){
            Node oldNode = q.poll();

            for (Node neighbor : oldNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                // 关键一步：把“旧邻居的新分身”连到“当前旧节点的新分身”上
                visited.get(oldNode).neighbors.add(visited.get(neighbor));
            }  
        }
        return visited.get(node);
    }
}
