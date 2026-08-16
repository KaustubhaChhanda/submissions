class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[58];
        
        for (char ch : s.toCharArray()) {
            freq[ch - 'A']++;
        }

        boolean isOddTaken = false;
        int length = 0;

        for (int f : freq) {
            if (f % 2 == 0) {
                length += f;
            } else {
                if (!isOddTaken) {
                    length += f;
                    isOddTaken = true;
                } else {
                    length += f - 1;
                }
            }
        }

        return length;
    }
}