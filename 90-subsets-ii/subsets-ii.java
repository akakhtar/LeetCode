class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n  =nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int start  = 0, end = 0;
        for(int i = 0;i<n;i++){
            start = 0;
            if(i>0 && nums[i] == nums[i-1])  start = end+1;
            end = res.size()-1;
            for(int j  = start;j<end+1;j++){
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }
        return res;
    }
}