class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
      int[] subSum = new int[nums.length-k+1];
      for(int i = 0;i<k;i++){
         subSum[0]+=nums[i];
      }
      for(int i = 1;i<nums.length-k+1;i++){
         subSum[i] = subSum[i-1]-nums[i-1]+nums[i+k-1];
      }
      
      int[] leftMax = new int[subSum.length];
      int maxIndex = 0;
      for(int i = 0;i<subSum.length;i++){
        if(subSum[i]>subSum[maxIndex]) maxIndex = i;
        leftMax[i] = maxIndex;
      }

      int[] rightMax = new int[subSum.length];
      maxIndex = subSum.length-1;
      for(int i = subSum.length-1;i>=0;i--){
        if(subSum[i] >= subSum[maxIndex]) maxIndex = i;
        rightMax[i] = maxIndex;
      }

      int[] result = new int[3];
      int maxSum = 0;

      for(int mid = k;mid<subSum.length-k;mid++){
        int l = leftMax[mid-k];
        int r = rightMax[mid+k];
        int total = subSum[l]+subSum[mid]+subSum[r];
        if(total > maxSum){
            maxSum = total;
            result[0] = l;
            result[1] = mid;
            result[2] = r;
        }
      }

      return result;
    }
}