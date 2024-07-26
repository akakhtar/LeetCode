class Solution {
    void fun(int index,int[] nums, List<Integer> currPermute,List<List<Integer>> subset){
        if(index == nums.length){
            subset.add(new ArrayList<>(currPermute));
        }
        else {
            for(int i = 0;i<currPermute.size() +1;i++){
                List<Integer> newPermute = new ArrayList<>(currPermute);
                newPermute.add(i,nums[index]);
                fun(index+1,nums,newPermute,subset);

            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        fun(0,nums,new ArrayList<>(), subset);
        return subset;
    }
}