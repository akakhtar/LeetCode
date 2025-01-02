class Solution {
   
   public boolean isVowel(char ch){
    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
    return true;
    return false;
   }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowel = new int[words.length];
        int[] res = new int[queries.length];

        for(int i = 0;i<words.length;i++){
            String word = words[i];
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length()-1);
            if(isVowel(firstChar) && isVowel(lastChar)){
                vowel[i] = 1;
            } 
            else vowel[i] = 0;
        }

        // for(int i = 0;i<queries.length;i++){
        //     for(int j = queries[i][0];j<=queries[i][1];j++){
        //         res[i]+= vowel[j];
        //     }
        // }
        int[] prefixSum = new int[vowel.length+1];
        for(int i = 0;i<vowel.length;i++){
            prefixSum[i+1] = prefixSum[i]+vowel[i];
        }

        for(int i = 0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = prefixSum[end+1]-prefixSum[start];
        }
        return res;
    }
}