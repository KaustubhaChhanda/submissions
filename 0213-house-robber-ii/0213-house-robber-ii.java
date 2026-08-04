class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int robFirst = dfs(nums, 0, n - 2, new Integer[n]);
        int skipFirst = dfs(nums, 1, n - 1, new Integer[n]);

        return Math.max(robFirst, skipFirst);
    }

    private int dfs(int[] nums, int index, int end, Integer[] memo) {
        if (index > end) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int skip = dfs(nums, index + 1, end, memo);
        int rob = nums[index] + dfs(nums, index + 2, end, memo);

        return memo[index] = Math.max(skip, rob);
    }
}