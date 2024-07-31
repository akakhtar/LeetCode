class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[0] - b[0]); // Sort rides by start time
        Map<Integer, Long> memo = new HashMap<>(); // Memoization map
        return fun(rides, 0, memo);
    }

    private long fun(int[][] rides, int i, Map<Integer, Long> memo) {
        if (i >= rides.length) return 0; // Base condition for the end of the array

        if (memo.containsKey(i)) return memo.get(i); // Check if result is already computed

        // Binary search to find the next ride that starts after the current ride ends
        int nextRide = binarySearch(rides, rides[i][1]);

        // Pick the current ride
        long pick = (rides[i][1] - rides[i][0] + rides[i][2]) + fun(rides, nextRide, memo);

        // Skip the current ride
        long notPick = fun(rides, i + 1, memo);

        // Store the result in memo and return the maximum profit
        long maxProfit = Math.max(pick, notPick);
        memo.put(i, maxProfit);
        return maxProfit;
    }

    private int binarySearch(int[][] rides, int target) {
        int left = 0, right = rides.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (rides[mid][0] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}