class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (char ch : s1.toCharArray()) {
            f1[ch - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            f2[s2.charAt(right) - 'a']++;
            right++;

            if (right - left == s1.length()) {
                if (Arrays.equals(f1, f2)) {
                    return true;
                }

                f2[s2.charAt(left) - 'a']--;
                left++;
            }
        }

        return false;
    }
}