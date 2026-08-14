class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length][2];
        return dfs(prices, 0, 0, memo);
    }

    private int dfs(int[] prices, int index, int isHolding, Integer[][] memo) {
        if (index == prices.length) {
            return 0;
        }

        if (memo[index][isHolding] != null) {
            return memo[index][isHolding];
        }

        int skip = dfs(prices, index + 1, isHolding, memo);
        int action = Integer.MIN_VALUE;

        if (isHolding == 0) {
            action = -prices[index] + dfs(prices, index + 1, 1, memo);
        } else {
            action = prices[index];
        }

        return memo[index][isHolding] = Math.max(skip, action);
    }
}