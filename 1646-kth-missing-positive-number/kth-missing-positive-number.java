class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int a:arr){
            if(a>k) return k;
            else k++;
        }
        return k;
    }
}