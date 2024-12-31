class Solution {
    int solve(int[] days,int[] costs,int currIndex, Map<Integer,Integer> dp){
       if(currIndex >= days.length) return 0;
       if(dp.containsKey(currIndex))
         return dp.get(currIndex);
       
       int cost1 = costs[0]+solve(days,costs,currIndex+1,dp);

       int i = currIndex;
       while(i < days.length && days[i]<days[currIndex]+7){
        i++;
       }
       int cost7 = costs[1]+solve(days,costs,i,dp);

       i = currIndex;
       while(i < days.length && days[i]<days[currIndex]+30){
        i++;
       }
       int cost30 = costs[2]+solve(days,costs,i,dp);

       int minCost = Math.min(cost1,Math.min(cost7,cost30));
       dp.put(currIndex,minCost);
       return minCost;
    }

    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer,Integer> dp = new HashMap<>();
      return solve(days,costs,0,dp);
    }
}