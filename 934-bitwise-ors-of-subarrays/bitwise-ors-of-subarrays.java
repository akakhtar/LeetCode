class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for(int a:arr){
            Set<Integer> curr = new HashSet<>();
            curr.add(a);
            for(int p:prev){
                curr.add(p|a);
            }
            res.addAll(curr);
            prev = curr;
        }
        return res.size();
    }
}