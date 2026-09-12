class Solution {
    public int maxDistinct(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int count = 0;

        for (int f : freq) {
            if (f != 0) {
                count++;
            }
        }

        return count;
    }
}