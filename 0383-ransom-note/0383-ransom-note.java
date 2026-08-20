class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] rfreq = new int[26];
        int[] mfreq = new int[26];

        for (char ch : ransomNote.toCharArray()) {
            rfreq[ch - 'a']++;
        }

        for (char ch : magazine.toCharArray()) {
            mfreq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (rfreq[i] > mfreq[i]) {
                return false;
            }
        }

        return true;
    }
}