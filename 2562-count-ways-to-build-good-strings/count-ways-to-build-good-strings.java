class Solution {
    public final int MOD = 1_000_000_007;
    
    int solve(int low,int high,int zero,int one,int len,int[] dp){
       if(len > high) return 0;
       if(dp[len] !=-1) return dp[len];

       int count = len>=low?1:0;
       count += solve(low,high,zero,one,len+zero,dp)%MOD;
       count += solve(low,high,zero,one,len+one,dp)%MOD;
      
       dp[len] = count%MOD;
       return dp[len];
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp,-1);
        return solve(low,high,zero,one,0,dp);
    }
}