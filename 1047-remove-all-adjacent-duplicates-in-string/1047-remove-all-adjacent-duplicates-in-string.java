class Solution {
    public String removeDuplicates(String s) {
        char[] arr = new char[s.length()];
        int index = 0;

        for (char ch : s.toCharArray()) {
            if (index > 0 && arr[index - 1] == ch) {
                arr[index - 1] = '\u0000';
                index--;
            } else {
                arr[index++] = ch;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : arr) {
            if (ch != '\u0000') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}