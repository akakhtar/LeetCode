class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int part = 1;
            int sum = 0;

            for (int num : nums) {
                if (sum + num > mid) {
                    part++;
                    sum = num;
                } else {
                    sum += num;
                }
            }

            if (part > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
