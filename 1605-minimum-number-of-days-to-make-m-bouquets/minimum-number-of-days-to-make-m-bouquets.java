class Solution {
    boolean possible(int day,int[] arr,int m,int k){
         int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
            
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length) return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int day : bloomDay){
            low = Math.min(low,day);
            high = Math.max(high,day);
        }
        while(low <= high){
            int mid = (low+high)/2;
            if(possible(mid,bloomDay,m,k)) high = mid - 1 ;
            else low = mid + 1;
        }
        return low;
    }
}