class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int visited[][] = new int[m][n];
        int ans = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]!=0) ans  = Math.max(dfs(grid,visited,i,j),ans);
            }
        }
        return ans;

    }
    int dfs(int[][] grid,int[][] visited,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || visited[i][j] == 1 || grid[i][j] == 0) return Integer.MIN_VALUE;
        visited[i][j] = 1;
        int left = dfs(grid,visited,i,j-1);
        if(left<0) left = 0;
        int right = dfs(grid,visited,i,j+1);
        if(right<0) right = 0;
        int down = dfs(grid,visited,i+1,j);
        if(down<0) down = 0;
        int up = dfs(grid,visited,i-1,j);
        if(up<0) up = 0;
        visited[i][j] = 0;
        int max = Math.max(Math.max(left,right),Math.max(up,down));
        return max + grid[i][j];
    }
}