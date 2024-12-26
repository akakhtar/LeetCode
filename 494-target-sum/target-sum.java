class Solution {
   
    int fun(int[] nums,int i, int sum, int target){
        if(nums.length == i)
         return sum==target?1:0;

        int pos = fun(nums,i+1,sum+nums[i],target);
        int neg = fun(nums,i+1,sum-nums[i],target);

        return pos+neg; 
    }

    public int findTargetSumWays(int[] nums, int target) {
        int count  = 0;
        return fun(nums,0,0,target);
    }
}