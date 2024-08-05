class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int m  = logs.length;
        int res = logs[0][0];
        int longestTime = logs[0][1];
        for(int i = 1;i<m;i++){
            if(longestTime<logs[i][1]-logs[i-1][1]){
                res = logs[i][0];
                longestTime = logs[i][1] - logs[i-1][1];
            }
            else if(longestTime == logs[i][1]-logs[i-1][1] && logs[i][0]<res){
                 res = logs[i][0];
                longestTime = logs[i][1] - logs[i-1][1];
            }
        }
        return res;
    }
}