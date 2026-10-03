class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minKIdx = -1;
        int maxKIdx = -1;
        int invalidIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == minK) {
                minKIdx = i;
            }

            if (num == maxK) {
                maxKIdx = i;
            }

            if (num < minK || num > maxK) {
                invalidIdx = i;
                minKIdx = -1;
                maxKIdx = -1;
            }

            if (minKIdx != -1 && maxKIdx != -1) {
                if (invalidIdx != -1) {
                    count += Math.min(minKIdx, maxKIdx) - invalidIdx;
                } else {
                    count += Math.min(minKIdx, maxKIdx) + 1;
                }
            }
        }

        return count;
    }
}