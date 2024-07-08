class Solution {
    int totalTime(int k,int[] arr){
        int sum = 0;
        for(int a : arr){
            sum += Math.ceil((double)a/(double)k);
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int p : piles)
          high = Math.max(high,p);
        int ans = 0;
        while(low <= high){
            int mid = (low+high)/2;
            int time = totalTime(mid,piles);
            if(time<=h){
              ans = Math.max(ans,mid);
              high = mid -1;
            }
            else low = mid + 1;
        }
        return low;
    }
}