class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length; 
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < n; i++) {
            int x = lower - nums[i];
            int y = upper - nums[i];

            int left = i + 1, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int start = left;

            left = i + 1;
            right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= y) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int end = right;

            if (start <= end) {
                count += (end - start + 1);
            }
        }
        return count;
    }
}
