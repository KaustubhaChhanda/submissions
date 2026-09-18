class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0, miss = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            while (right < nums.length && miss <= k) {
                if (nums[right] == 0) {
                    miss++;
                }

                right++;
            }

            max = Math.max(max, right - left);

            while (left < right && miss > k) {
                if (nums[left] == 0) {
                    miss--;
                }

                left++;
            }
        }

        max = Math.max(max, right - left + 1);

        return max - 1;
    }
}