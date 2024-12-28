class Solution {

    int binarySearchFirst(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left  + (right-left)/2;
            if(nums[mid]>target)
              right = mid-1;
            else if(nums[mid]<target)
              left = mid+1;
             else{ 
            if(mid==0 || nums[mid-1]!=nums[mid])
              return mid;
            else right = mid-1;  
             }    
        }
        return -1;
    }

   int binarySearchLast(int[] nums,int target){
    int left = 0;
    int right = nums.length-1;
    while(left<=right){
        int mid = left+(right-left)/2;
        if(nums[mid]>target)
        right = mid-1;
        else if(nums[mid]<target)
        left = mid+1;
        else{
        if(mid==nums.length-1 || nums[mid]!=nums[mid+1])
        return mid;
        else left = mid+1;
        }
    }
    return -1;
   } 

    public int[] searchRange(int[] nums, int target) {
        int x = binarySearchFirst(nums,target);
        int y = binarySearchLast(nums,target);

    return new int[]{x,y};    
    }
}