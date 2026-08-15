class Solution {
    public boolean validPalindrome(String s) {
        return dfs(s, 0, s.length() - 1,  1);
    }

    private   boolean dfs(String s, int left, int right, int del) {
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) == s.charAt(right)) {
            return dfs(s, left + 1, right - 1, del);
        } else {
            if (del != 0) {
                return dfs(s, left + 1, right, 0) || dfs(s, left,  right - 1, 0);
            } else {
                return false;
            }
        }
    }
}