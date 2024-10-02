class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int sortedArr[] = arr.clone();
        Arrays.sort(sortedArr);
        int[] result = new int[n];
        
        Map<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : sortedArr){
            if(!map.containsKey(num)){
                map.put(num,rank);
                rank++;
            }
        }

        for(int i = 0;i<n;i++)
         result[i] = map.get(arr[i]);
        return result;   
    
    }
}