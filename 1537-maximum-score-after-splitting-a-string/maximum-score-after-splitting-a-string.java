class Solution {
    public int maxScore(String s) {
        int score  = 0;
        int nOne = 0, nZero = 0;
        for(int i = 0;i<s.length();i++)
           if(s.charAt(i)=='1') nOne++;

        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == '0') nZero++;
            else nOne--;
            score = Math.max(score,nOne+nZero);
        }
        return score;   
    }
}