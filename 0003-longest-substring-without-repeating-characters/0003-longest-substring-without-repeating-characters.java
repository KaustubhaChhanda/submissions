class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int max = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            left = Math.max(left, last[ch - (char) 0]);
            max = Math.max(max, right - left + 1);
            last[s.charAt(right) - (char) 0] = right + 1;
        }

        return max;
    }
}