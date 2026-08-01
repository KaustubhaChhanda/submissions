class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return dfs(nums, 0, nums.length - 1, memo) >= 0;
    }

    private int dfs(int[] nums, int left, int right, Integer[][] memo) {
        if (left > right) {
            return 0;
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int leftScore = nums[left] - dfs(nums, left + 1, right, memo);
        int rightScore = nums[right] - dfs(nums, left, right - 1, memo);

        return memo[left][right] = Math.max(leftScore, rightScore);
    }
}