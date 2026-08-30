class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        int left = -1, right = -1;
        
        if (minIdx < maxIdx) {
            left  = minIdx;
            right = maxIdx;
        } else {
            left = maxIdx;
            right = minIdx;
        }

        return Math.min((left + 1) + (n - right), Math.min(right + 1, n - left));
    }
}