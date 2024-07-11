class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                if(grid[i][j]!=0) countFresh++;
            }
        }
        if(countFresh == 0) return 0;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,-1,0,1};
        int count = 0,countMin = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count += size;
            for(int i = 0;i<size;i++){
                int[] point = q.poll();
                for(int k = 0;k<4;k++){
                    int x = point[0] + delRow[k];
                    int y = point[1] + delCol[k];
                    if(x<0 || x>=m || y<0 || y>=n || grid[x][y]==0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y});
                }
            }
            if(q.size()!=0){
                countMin++;
            }
            

        }
        return countFresh == count?countMin:-1;
    }
}