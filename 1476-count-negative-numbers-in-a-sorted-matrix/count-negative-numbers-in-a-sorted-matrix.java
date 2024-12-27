class Solution {
    public int countNegatives(int[][] grid) {
        int count  = 0;
        for(int i = 0;i<grid.length;i++){
           int left = 0;
           int right = grid[0].length-1;
           int index = -1;
           while(left<=right){
            int mid = (left+right+1)/2;
            if(grid[i][mid]>=0) {
                index = mid;
                left = mid+1;
            }
            else
              right = mid-1; 
           }
           count += (grid[0].length-index-1);
        }
        return count;
    }
}