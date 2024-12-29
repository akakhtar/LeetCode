class Solution {
    static final int MOD = 1_000_000_007;

    public int solve(String target,int[][] freq,int i,int k){
        if(i == target.length()) return 1;
        if(k == freq.length) return 0;

        long result = solve(target,freq,i,k+1);

        char currentChar = target.charAt(i);
        int charIndex = currentChar - 'a';
        if(freq[k][charIndex] > 0){
            result += (long)freq[k][charIndex]*solve(target,freq,i+1,k+1);
            result %= MOD;
        }

     return (int)result;
        
    }

    public int numWays(String[] words, String target) {
        int m = words.length;
        int n = words[0].length();
        
        int[][] freq = new int[n][26];
        for(String word:words){
          for(int i =0;i<n;i++){
            freq[i][word.charAt(i)-'a']++;
          }
        }

        long[][] dp = new long[target.length()+1][n+1];

        for(int k = 0;k<=n;k++){
            dp[target.length()][k] = 1;
        }

        for(int i = target.length()-1;i>=0;i--){
            for(int k = n-1;k>=0;k--){
                dp[i][k] = dp[i][k+1];
                char currentChar = target.charAt(i);
                int charIndex = currentChar-'a';
                if(freq[k][charIndex]>0){
                    dp[i][k] = (dp[i][k]+(long)freq[k][charIndex] * dp[i+1][k+1]) % MOD;
                }
            }
        }

        // return solve(target, freq,0,0);
        return (int)dp[0][0];
    }
}