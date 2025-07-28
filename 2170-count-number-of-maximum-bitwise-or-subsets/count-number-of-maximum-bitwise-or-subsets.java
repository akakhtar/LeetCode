class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int totalSubset = 1 << nums.length;
        int maxBitWise = nums[0];
        for(int i = 1;i<nums.length;i++)
           maxBitWise = maxBitWise | nums[i];
        int count  = 0;
        for(int i = 0;i<totalSubset;i++){
            int currBitWise = 0;
           for(int j = 0;j<nums.length;j++){
              if((i&(1<<j))>0) currBitWise = currBitWise | nums[j];
           }
           if(currBitWise == maxBitWise) count++;
        }
        return count;   
    }
}