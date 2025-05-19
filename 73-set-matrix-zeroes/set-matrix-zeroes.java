class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet r = new HashSet<Integer>();
        HashSet c = new HashSet<Integer>();
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
              if(matrix[i][j] == 0) {
                r.add(i);
                c.add(j);
              }
            }
        }


        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(r.contains(i) || c.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}