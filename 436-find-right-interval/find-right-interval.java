class Pair{
    private int index;
    private int[] interval;
    
    public Pair(int index,int[] interval){
        this.index = index;
        this.interval = interval;
    }
    public int getIndex(){
        return index;
    }
    public int[] getInterval(){
        return interval;
    }
}
class Solution {
    private int binarySearch(Pair[] pairs,int target){
        int left = 0, right = pairs.length-1;
        int resultIndex = -1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(pairs[mid].getInterval()[0]>=target){
                resultIndex = pairs[mid].getIndex();
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return resultIndex;
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Pair[] pairs = new Pair[n];
        for(int i = 0;i<n;i++){
           pairs[i]=new Pair(i,intervals[i]);
        }

        Arrays.sort(pairs,(a,b) -> Integer.compare(a.getInterval()[0],b.getInterval()[0]));

        int[] result = new int[n];

        for(int i = 0;i<n;i++){
            int end = intervals[i][1];
            int index = binarySearch(pairs,end);
            result[i] = index;
        }
        return result;
    }
}