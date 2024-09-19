class Solution {
    boolean possible(int[] pos,int length,int m){
        int last  = pos[0],count  = 1;
        for(int i = 1;i<pos.length;i++){
            if(pos[i]-last>=length){
                count++;
                last  =pos[i];
            }
                if(count==m) return true;
        }
        return false;
        
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int max = position[n-1];
        int low = 1, high = max;
        int result  = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(!possible(position,mid,m)) 
              {
                high = mid-1;
              }
              else {
                result = mid;
                low = mid + 1;
              }
        }
        return result;
    }
}