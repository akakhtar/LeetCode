class Solution {
    int maxSize = 0;
    public int largestCombination(int[] candidates) {
       int[] bitCount  = new int[32];

       for(int candidate:candidates){
        for(int i = 0;i<32;i++){
            if((candidate&(1<<i)) != 0){
                bitCount[i]++;
            }
        }
       }
       int maxCount = 0;
       for(int count : bitCount)
        maxCount = Math.max(count,maxCount);
        return maxCount;
    }

    public void dfs(int[] candidates,int index,int currAnd,int count){
        //base case
        if(index == candidates.length){
            if(currAnd > 0){
                maxSize = Math.max(maxSize,count);
            }
            return ;
        }

        dfs(candidates,index+1,currAnd & candidates[index],count+1);

        dfs(candidates,index+1,currAnd,count);

    }
}