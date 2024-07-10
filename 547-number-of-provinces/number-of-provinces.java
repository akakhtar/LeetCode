class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0;i<n;i++){
            if(visited[i] == false){
                count++;
                dfs(i,visited,isConnected);
            }
        }
        return count;
    }
    void dfs(int curr,boolean[] visited,int [][] isConnected){
        visited[curr] = true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[curr][i] == 1 && visited[i]==false) dfs(i,visited,isConnected);
        }
    }
}