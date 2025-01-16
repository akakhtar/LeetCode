class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans = 0;
        if(n1%2==0 && n2%2==0) return 0;
        else if(n1%2 == 0 && n2%2!=0) {
            for(int i = 0;i<n1;i++)
              ans ^= nums1[i];
        }
        else if(n1%2!=0 && n2%2==0){
            for(int j = 0;j<n2;j++){
                ans ^= nums2[j];
            }
        }
        else{
            for(int i = 0;i<n1;i++){
                ans ^= nums1[i];
            }
            for(int j = 0;j<n2;j++){
                ans ^= nums2[j];
            }
        }
        return ans;
    }
}