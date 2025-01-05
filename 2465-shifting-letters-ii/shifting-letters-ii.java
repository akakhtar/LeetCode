class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] temp = new int[s.length()+1];
        for(int i = 0;i<shifts.length;i++){
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2] == 0?-1:1;

            temp[start] += direction;
            if(end+1 < temp.length) temp[end+1] -= direction;
        }
        for(int i = 1;i<temp.length-1;i++){
            temp[i] = temp[i]+temp[i-1];
        }
        
         StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int currentShift = temp[i] % 26; 
            if (currentShift < 0) {
                currentShift += 26; 
            }
            char shiftedChar = (char) ((s.charAt(i) - 'a' + currentShift) % 26 + 'a');
            result.append(shiftedChar);
        }
        
        return result.toString();
    }
}