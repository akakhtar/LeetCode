class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = -1;
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            int s = 0;
            while(num>0){
                s += num%10;
                num /= 10;
            }
            if(map.containsKey(s)){
              int  sum = nums[i] + map.get(s);
               res = Math.max(sum,res);
            }
              map.put(s, Math.max(map.getOrDefault(s, 0), nums[i]));
        }
        return res;


    }
}