class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] arrStartTime = new int[n];
        int[] arrEndTime = new int[n];
        for(int i = 0;i<n;i++){
            arrStartTime[i] = intervals[i][0];
            arrEndTime[i] = intervals[i][1];
        }
        Arrays.sort(arrStartTime);
        Arrays.sort(arrEndTime);
        int end = 0, count = 0;
        for(int start : arrStartTime){
            if(start>arrEndTime[end])
            end++;
            else 
            count++;
        }
        return count;
    }
}