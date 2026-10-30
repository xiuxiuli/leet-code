package tree;

public class _297_Serialize_and_Deserialize_Binary_Tree {
    // Encodes a tree to a single string.
    // 1. 序列化：前序遍历拼字符串
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serializeDfs(root, sb);
        
        return sb.toString();
    }

    private void serializeDfs(TreeNode node, StringBuilder sb) {
        if(node == null){
            sb.append("#,");// 空节点用 # 表示，用逗号分隔
            return;
        }

        // 根 -> 左 -> 右
        sb.append(node.val).append(",");
        serializeDfs(node.left, sb);
        serializeDfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    // 2. 反序列化：队列 + 递归拆解
    public TreeNode deserialize(String data) {
        // 用逗号切分，全部塞进队列里，方便按顺序消费
        String[] nodes = data.split(",");

        Queue<String> q = new LinkedList<>(Arrays.asList(nodes));
        return deserializeDfs(q);
    }

    private TreeNode deserializeDfs(Queue<String> queue){
        String val = queue.poll();

        if(val.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = deserializeDfs(queue);
        node.right = deserializeDfs(queue);

        return node;
    }
}