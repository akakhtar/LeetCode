class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i = 0;i<s.length();i++)
         freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);

          LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
        freq.entrySet()
            .stream()
            .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
            .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

          StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            // Append the character 'value' number of times
            for (int i = 0; i < value; i++) {
                result.append(key);
            }
        }

        // Convert StringBuilder to String
        String output = result.toString();
        return output;


    }
}