package data_structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class NestedInteger {
    private int val;
    private List<NestedInteger> list;

    public NestedInteger(int val) {
        this.val = val;
        this.list =  new ArrayList<>();
    }

    public NestedInteger(List<NestedInteger> list){
        this.val = null;
        this.list = list;
    }

    public boolean isInteger(){
        return val != null;
    }

    public Integer getIngeter() {
        return val;
    }

    public List<NestedInteger> getList(){
        return list;
    }
}

public class DfsBfs {

    public static void dfs(NestedInteger ni) {
        if (ni.isInteger()){
            System.out.print(ni.getInteger() + " ");
            return;
        }
        for (NestedInteger child :  ni.getList()) {
            dfs(child);
        }
    }

    public static void bfs(NestedInteger root) {
        Queque<NestedInteger> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty){
            NestedInteger cur = q.poll();
            if (cur.isInteger()){
                System.out.print(cur.getInteger() + " ");
            } else{
                for (NestedInteger child : cur.getList()){
                    q.offer(child);
                }
            }
        }
    }
}

