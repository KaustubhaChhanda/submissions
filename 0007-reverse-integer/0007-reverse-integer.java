class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        StringBuilder num = new StringBuilder(String.valueOf(Math.abs(x)));
        num.reverse();
        int rev = 0;

        try {
            rev = Integer.parseInt(num.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return isNeg ? -rev : rev;
    }
}