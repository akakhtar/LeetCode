class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = Integer.MIN_VALUE;
        int l = 0, r = n-1;
        int min = 0, water = 0;
        while(l<r){
            if(height[l]<height[r]){
                water = (r-l)*height[l];
                l++;
            }
            else {
                water = (r-l)*height[r];
                r--;
            }
            ans = Math.max(ans,water);
        }
        return ans;
    }
}