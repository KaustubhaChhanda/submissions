class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        if (pattern.length() != words.length) {
            return false;
        } 

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (!map.containsKey(ch)) {
                if (set.contains(words[i])) {
                    return false;
                }

                map.put(ch, words[i]);
                set.add(words[i]);
            } else {
                if (!map.get(ch).equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}