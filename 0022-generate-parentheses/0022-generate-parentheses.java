class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return result;
    }

    private void backtrack(int open, int close, StringBuilder current) {
        if (open == 0 && close == 0) {
            result.add(current.toString());
            return;
        }

        if (open > 0) {
            current.append('(');
            backtrack(open - 1, close, current);
            current.deleteCharAt(current.length() - 1);
        }

        if (close > open) {
            current.append(')');
            backtrack(open, close - 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}