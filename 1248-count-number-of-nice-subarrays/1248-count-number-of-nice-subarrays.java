class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);   
    }

    private int atMost(int[] nums, int k) {
        int left = 0, right = 0, count = 0, ans = 0;

        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                count++;
            }

            while (count > k) {
                if (nums[left] % 2 != 0) {
                    count--;
                }

                left++;
            }

            ans += right - left + 1;
            right++;
        }

        return ans;
    }
}