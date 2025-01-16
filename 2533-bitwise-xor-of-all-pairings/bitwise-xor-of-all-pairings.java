class Solution {
    int xor(int[] nums){
        int res = 0;
        for(int i = 0;i<nums.length;i++)
          res ^= nums[i];
        return res;  
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans = 0;
        if(n1%2==0 && n2%2==0) return 0;
        else if(n1%2 == 0 && n2%2!=0) {
            ans = xor(nums1);
        }
        else if(n1%2!=0 && n2%2==0){
           ans = xor(nums2);
        }
        else{
            ans = xor(nums1)^xor(nums2);
        }
        return ans;
    }
}