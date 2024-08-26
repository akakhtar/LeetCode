class Solution {
    public int beautySum(String s) {
        int n = s.length();
        
        int sum = 0;
        for(int i = 0;i<n;i++)
        {
            int freq[] = new int[26];
            for(int j = i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                int max = -1;
                int min = 1000;
                for(int k = 0;k<26;k++){
                    if(freq[k]!=0){
                       max = Math.max(max,freq[k]);
                       min = Math.min(min,freq[k]);
                    }
                }
                if(max!=-1 && min!=1000) sum += (max-min);
            }
        }
        return sum;
    }
}