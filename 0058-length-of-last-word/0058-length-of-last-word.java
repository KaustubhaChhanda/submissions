class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0, index = s.length() - 1;

        while (index >= 0 && s.charAt(index) == ' '){
            index--;
        }

        while  (index >= 0 && s.charAt(index) != ' ') {
            index--;
            length++;
        }

        return length;
    }
}