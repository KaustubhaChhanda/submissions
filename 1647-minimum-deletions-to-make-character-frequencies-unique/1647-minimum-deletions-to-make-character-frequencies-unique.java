class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int del = 0;

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        int i = 24;

        while (i >= 0) {
            if (freq[i] != 0 && freq[i] == freq[i + 1]) {
                freq[i]--;
                del++;
                Arrays.sort(freq);
                i = 24;
            } else {
                i--;
            }
        }

        return del;
    }
}