class Solution {
    public int fib(int n) {
        return dfs(n, new Integer[n + 1]);
    }

    private int dfs(int n, Integer[] memo) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        if (memo[n] != null) return memo[n];

        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
    }
}