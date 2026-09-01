class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) {
            return list;
        }
        
        int[] pfreq = new int[26];

        for (char ch : p.toCharArray()) {
            pfreq[ch - 'a']++;
        }

        int[] sfreq = new int[26];
        int left = 0, right = 0;

        while (right < p.length()) {
            sfreq[s.charAt(right) - 'a']++;
            right++;
        }

        while (right < s.length()) {
            if (Arrays.equals(sfreq, pfreq)) {
                list.add(left);
            }

            sfreq[s.charAt(right++) - 'a']++;
            sfreq[s.charAt(left++) - 'a']--;
        }

        if (Arrays.equals(sfreq, pfreq)) {
            list.add(left);
        }

        return list;
    }
}