class Solution {

   int binarySearch(int[] nums,int target,int first){
    int left = 0;
    int right = nums.length-1;
    while(left<=right){
        int mid = left+(right-left)/2;
        if(nums[mid]>target)
        right = mid-1;
        else if(nums[mid]<target)
        left = mid+1;
        else{
        if(first == 0){        
        if(mid==nums.length-1 || nums[mid]!=nums[mid+1])
        return mid;
        else left = mid+1;
        }
        else{
            if(mid==0 || nums[mid-1]!=nums[mid])
              return mid;
            else right = mid-1; 
        }
        }
    }
    return -1;
   } 

    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums,target,1);
        int last = binarySearch(nums,target,0);

    return new int[]{first,last};    
    }
}