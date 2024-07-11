class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0;i<n;i++){
            if(grid[0][i] == 1 && !visited[0][i])
              dfs(0,i,visited,grid);
            if(grid[m-1][i] == 1 && !visited[m-1][i])
              dfs(m-1,i,visited,grid);  
        }

        for(int i = 0;i<m;i++){
            if(grid[i][0] == 1 && !visited[i][0])
              dfs(i,0,visited,grid);
            if(grid[i][n-1] == 1 && !visited[i][n-1])
              dfs(i,n-1,visited,grid);  
        }

        int count  = 0;
        for(int i = 1;i<m-1;i++){
            for(int j = 1;j<n-1;j++){
                if(grid[i][j]==1 && !visited[i][j]) count++;
            }
        }
        return count;

    }

    void dfs(int i,int j, boolean[][] visited, int[][] grid){
        visited[i][j] = true;
        int drow[] = {-1,1,0,0};
        int dcol[] = {0,0,-1,1};
        for(int k = 0;k<4;k++){
            int row = i+drow[k];
            int col = j+dcol[k];
            if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col] == 1 && !visited[row][col])
             dfs(row,col,visited,grid);
        }
    }
}