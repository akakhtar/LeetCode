class Solution {
    public int solve(String word1, String word2,int i,int j,int[][] dp){
        if(i == word1.length()) return word2.length()-j;
        if(j == word2.length()) return word1.length()-i;
        if(dp[i][j] != -1) return dp[i][j];
        int  ans = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            return solve(word1,word2,i+1,j+1,dp);
        }
        else{
            int insertAns = 1+ solve(word1,word2,i,j+1,dp);
            int deleteAns = 1+ solve(word1,word2,i+1,j,dp);
            int replaceAns = 1+ solve(word1,word2,i+1,j+1,dp);
            ans = Math.min(insertAns,Math.min(deleteAns,replaceAns));
        }
        return dp[i][j] = ans;
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int[] arr : dp){
            Arrays.fill(arr,0);
        }
        for(int j=0;j<word2.length();j++)
         dp[word1.length()][j] = word2.length()-j;
        for(int i=0;i<word1.length();i++)
         dp[i][word2.length()] = word1.length()-i;

         for(int i = word1.length()-1;i>=0;i--){
            for(int j = word2.length()-1;j>=0;j--){
                  int ans = 0;
                if(word1.charAt(i) == word2.charAt(j))
                  ans =  dp[i+1][j+1];
                 
                 else{
              
                int insertAns = 1 + dp[i][j+1];
                int removeAns = 1 + dp[i+1][j];
                int replaceAns = 1+dp[i+1][j+1];
                ans = Math.min(insertAns,Math.min(removeAns,replaceAns));  
            }
            dp[i][j] = ans;
            }
         }  
        return dp[0][0];
    }
}