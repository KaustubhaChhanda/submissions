class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        int prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            sum += Math.abs(prev - s.charAt(i));
            prev = s.charAt(i);
        }

        return sum;
    }
}