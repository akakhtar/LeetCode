class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int w:weights){
            low = Math.max(low,w);
            high += w;
        }
        while(low<=high){
            int mid = (low+high)/2;
            int d = 1;
            int load = 0;
            for(int w : weights){
                if(load+w>mid){
                    d++;
                    load = w;
                }
                else load += w;
            }

            if(d <= days) high = mid -1;
            else low = mid + 1;
        }
        return low;
    }
}