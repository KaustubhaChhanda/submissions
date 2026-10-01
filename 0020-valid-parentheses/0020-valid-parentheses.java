class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int index = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[index++] = ch;
            } else if (ch == ')') {
                if (index > 0 && stack[index - 1] == '(') {
                    stack[--index] = '\u0000';
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (index > 0 && stack[index - 1] == '{') {
                    stack[--index] = '\u0000';
                } else {
                    return false;
                }
            } else {
                if (index > 0 && stack[index - 1] == '[') {
                    stack[--index] = '\u0000';
                } else {
                    return false;
                }
            }
        }

        return index == 0;
    }
}