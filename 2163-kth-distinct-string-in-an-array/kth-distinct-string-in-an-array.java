import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<String> distinctList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) == 1) {
                distinctList.add(arr[i]);
            }
        }

        if (k > distinctList.size()) return "";

        return distinctList.get(k - 1);
    }
}
