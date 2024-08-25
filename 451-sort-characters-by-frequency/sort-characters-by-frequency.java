import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        StringBuilder result = new StringBuilder(s.length());
        for (Map.Entry<Character, Integer> entry : list) {
            char key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                result.append(key);
            }
        }

        return result.toString();
    }
}
