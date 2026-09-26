class Solution {
    public String removeStars(String s) {
        char[] stack = new char[s.length()];
        int index = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                stack[--index] = '\u0000';
            } else {
                stack[index++] = ch;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < index; i++) {
            sb.append(stack[i]);
        }

        return sb.toString();
    }
}