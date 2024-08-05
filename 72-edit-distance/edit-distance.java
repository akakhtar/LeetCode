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
        int dp[][] = new int[word1.length()][word2.length()];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(word1,word2,0,0,dp);
    }
}