class Solution {
    public int[] minOperations(String boxes) {
        int[] dist = new int[boxes.length()];

        int prefixCount = 0;
        int prefixSum = 0;
        for(int i = 0;i<boxes.length();i++){
            dist[i] = prefixCount*i-prefixSum;
            if(boxes.charAt(i) == '1'){
                ++prefixCount;
                prefixSum += i;
            }
        }

        int suffixCount = 0;
        int suffixSum = 0;

        for(int i = boxes.length()-1;i>=0;--i){
            dist[i] += suffixSum - suffixCount*i;
            if(boxes.charAt(i) == '1'){
                ++suffixCount;
                suffixSum += i;
            }
        }

        return dist;
    }
}