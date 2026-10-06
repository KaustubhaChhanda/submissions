class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int neg = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                neg++;
                count = 0;
            }
        }

        return count + neg;
    }
}