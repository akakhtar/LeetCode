class Solution {
    public int maximumLength(int[] nums, int k) {
        int res = 2;
        for(int i = 0; i <k;i++){
            int[] dp = new int[k];
            for(int j = 0;j<nums.length;j++){
                int sum = nums[j]%k;
                int pos = (i-sum+k)%k;
                dp[sum] = dp[pos]+1;
            }

            for(int val:dp){
                res = Math.max(res,val);
            }
        }
        return res;
    }
}