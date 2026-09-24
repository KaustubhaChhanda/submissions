class Solution {
    public int maxDepth(String s) {
        int max = 0;
        char[] stack = new char[s.length()];
        int index = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack[index++] = ch;
                max = Math.max(max, index);
            } else if (ch == ')') {
                stack[--index] = '\u0000';
            }
        }

        return max;
    }
}