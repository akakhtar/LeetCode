class Solution {
     int maxOr = 0;
     int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        for(int num : nums)
           maxOr |= num;

        dfs(nums,0,0);
        return count;     
    }

    public void dfs(int[] nums,int i,int currOr){
        //base case
        if(i == nums.length){
            if(currOr == maxOr) count++;
            return;
        }

        dfs(nums,i+1,currOr | nums[i]);

        dfs(nums,i+1,currOr);
    }
}