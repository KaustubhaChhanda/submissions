class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int curr = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                curr++;
            }

            right++;

            max = Math.max(max, curr);

            if (right >= k) {
                char lc = s.charAt(left);
                if (lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u') {
                    curr--;
                }

                left++;
            }
        }

        return max;
    }
}