class Solution {

    public boolean isPrefixSuffix(String s, String str){
       return str.startsWith(s) && str.endsWith(s);
    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0;i<words.length;i++){
            for(int j = i+1;j<words.length;j++){
                if(i!=j && isPrefixSuffix(words[i],words[j]))
                   count++;
            }
        }
        return count;
    }
}