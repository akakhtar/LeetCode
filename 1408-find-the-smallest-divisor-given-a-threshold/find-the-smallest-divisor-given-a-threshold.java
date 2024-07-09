class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 1;
        for(int num:nums)
         high = Math.max(high,num);
        int ans = high;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int sum = 0;
            for(int num : nums){
                sum += Math.ceil((double)num/(double)mid);
            }

            if(sum>threshold){
                low = mid + 1; 
            }
            else {
                ans = Math.min(ans,mid);
                high = mid - 1;
            }
        }
        return ans; 
    }
}