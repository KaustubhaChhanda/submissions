class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n];
        return dfs(piles, 0, n - 1, memo) > 0;
    }

    private int dfs(int[] piles, int left, int right, Integer[][] memo) {
        if (left > right) {
            return 0;
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int leftStones = piles[left] - dfs(piles, left + 1, right, memo);
        int rightStones = piles[right] - dfs(piles, left, right - 1, memo);

        return memo[left][right] = Math.max(leftStones, rightStones);
    }
}