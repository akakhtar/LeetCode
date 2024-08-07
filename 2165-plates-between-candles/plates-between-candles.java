class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> candlePos = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '|')
              candlePos.add(i);
        }
        int result[] = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int lb = lowerBound(candlePos,left);
            int ub = upperBound(candlePos,right) - 1;
            if(ub <= lb) result[i] = 0;
            else  result[i] = (candlePos.get(ub)-candlePos.get(lb) +1) - (ub - lb + 1);
        }
        return result;
    }
    int lowerBound(List<Integer> list,int target){
        int low = 0, high = list.size();
        while(low < high){
            int mid = (low + high)/2;
            if(list.get(mid)<target) low = mid +1;
            else high = mid;
        }
        return low;
    }
      int upperBound(List<Integer> list,int target){
        int low = 0, high = list.size();
        while(low < high){
            int mid = (low + high)/2;
            if(list.get(mid)<=target) low = mid +1;
            else high = mid;
        }
        return low;
    }
}