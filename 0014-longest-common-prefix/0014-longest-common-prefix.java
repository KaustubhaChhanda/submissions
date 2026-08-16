class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLen = 201;

        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);

            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch)  {
                    return sb.toString();
                }
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}