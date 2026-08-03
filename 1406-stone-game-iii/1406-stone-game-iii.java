class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer[] memo = new Integer[stoneValue.length];
        int score = dfs(stoneValue, 0, memo);

        if (score > 0) {
            return "Alice";
        } else if (score < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int dfs(int[] stones, int index, Integer[] memo) {
        if (index == stones.length) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int one = stones[index] - dfs(stones, index + 1, memo);

        int two = Integer.MIN_VALUE;
        if (index + 1 < stones.length) {
            two = stones[index] + stones[index + 1] - dfs(stones, index + 2, memo);
        }

        int three = Integer.MIN_VALUE;
        if (index + 2 < stones.length) {
            three = stones[index] + stones[index + 1] + stones[index + 2] - dfs(stones, index + 3, memo);
        }

        return memo[index] = Math.max(one, Math.max(two, three));
    }
}