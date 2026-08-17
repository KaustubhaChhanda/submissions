class Solution {
    public int missingNumber(int[] nums) {
        int max = 0;
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        if (max < nums.length) {
            return nums.length;
        }

        int actualSum = max * (max + 1) / 2;

        return actualSum - sum;
    }
}