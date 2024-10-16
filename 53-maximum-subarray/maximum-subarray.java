class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = -10000;
        int sum = nums[0];
        for(int i = 0;i<n;i++){
            max = Math.max(max+nums[i],nums[i]);
            sum = Math.max(sum,max);
        }
        return sum;
    }
}