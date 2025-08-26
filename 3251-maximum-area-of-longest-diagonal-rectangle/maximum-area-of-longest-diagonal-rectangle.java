class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double l_d = 0;
        int max_area = 0;
        for(int i = 0;i<dimensions.length;i++){
            double d = Math.sqrt(dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1]);
            if(d>l_d){
                max_area = dimensions[i][0]*dimensions[i][1];
                l_d = d;
            }
            else if(d == l_d){
                max_area = Math.max(max_area,dimensions[i][0]*dimensions[i][1]);
            }
        }
        return max_area;
    }
}