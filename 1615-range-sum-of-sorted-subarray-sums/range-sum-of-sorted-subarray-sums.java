class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int prefixSum = 0;
            for(int j = i;j<n;j++){
                prefixSum += nums[j];
                arr.add(prefixSum);
            }
        }
        Collections.sort(arr);
        int res = 0;
        int mod = 1000000007;
        for(int i = left-1;i<right;i++)
           res = (res+arr.get(i))%mod;
        return res;
    } 
}