class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int n = s.length();
        int ans = 0;
        int countZero = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                countZero++;
            } else if (s.charAt(i) == '1' && countZero > 0) {
                ans = Math.max(ans + 1, countZero);
            }
        }
        return ans;
    }
}
