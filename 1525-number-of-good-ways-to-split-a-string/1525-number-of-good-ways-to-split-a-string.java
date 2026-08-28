class Solution {
    public int numSplits(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int[] forward = new int[n];

        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
            forward[i] = set.size();
        }

        set = new HashSet<>();
        int[] backward = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            backward[i] = set.size();
        }

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (forward[i] == backward[i + 1]) {
                count++;
            }
        }

        return count;
    }
}