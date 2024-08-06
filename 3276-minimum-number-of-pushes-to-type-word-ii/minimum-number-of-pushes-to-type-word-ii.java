class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        for(int i = 0;i<word.length();i++){
          char ch = word.charAt(i);
          freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int res = 0;
        int count = 1 ,pres = 1;
        for(int i = 25;i>=0;i--){
            if(freq[i] != 0){
               if(count>8){
                  pres++;
                  count = 1;
               }
               res += freq[i]*pres;
               count++; 
            }
        }
        return res;
    }
}