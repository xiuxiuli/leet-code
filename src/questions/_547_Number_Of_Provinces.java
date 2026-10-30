package questions;

public class _547_Number_Of_Provinces {

    private void dfsFromNode(int[][] isConnected, boolean[] visited, int i){
        visited[i] = true;
        
        for(int j = 0; j < isConnected.length; j++){
            if (isConnected[i][j] == 1 && !visited[j]){
                dfsFromNode(isConnected, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                count++;
                dfsFromNode(isConnected, visited, i);     
            }
        }
        return count;
    }
}