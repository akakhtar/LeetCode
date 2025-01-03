class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(int num : nums)
         sum+= num;
        long leftSum = 0; int count = 0;
        for(int i = 0;i<nums.length-1;i++){
            leftSum += nums[i];
            if(leftSum >= sum-leftSum) count++;
        }
        return count; 
    }
}