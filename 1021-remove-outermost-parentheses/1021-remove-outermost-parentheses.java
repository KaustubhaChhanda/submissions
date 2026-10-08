class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        char[] stack = new char[s.length()];
        int top = -1;
        int pos = 0;

        int open = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {
            stack[++top] = ch;

            if (ch == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                top--;

                while (top > 0) {
                    sb.insert(pos, stack[top--]);
                }

                pos = sb.length();

                top--;

                open = 0;
                close = 0;
            }
        }

        return sb.toString();
    }
}