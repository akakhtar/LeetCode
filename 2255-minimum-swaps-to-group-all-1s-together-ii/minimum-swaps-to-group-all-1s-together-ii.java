class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOne = 0;

        for (int num : nums) {
            if (num == 1) totalOne++;
        }

        if (totalOne == 0 || totalOne == n) {
            return 0;
        }
        int minSwaps = Integer.MAX_VALUE;
        int currentZeroCount = 0;

        for (int i = 0; i < totalOne; i++) {
            if (nums[i] == 0) {
                currentZeroCount++;
            }
        }

        minSwaps = currentZeroCount;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == 0) {
                currentZeroCount--;
            }
            if (nums[(i + totalOne - 1) % n] == 0) {
                currentZeroCount++;
            }
            minSwaps = Math.min(minSwaps, currentZeroCount);
        }

        return minSwaps;
    }
}
