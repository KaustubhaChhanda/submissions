class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            fast = getSquareSum(getSquareSum(fast));
            slow = getSquareSum(slow);
        } while (slow != fast);

        return fast == 1;
    }

    private int getSquareSum(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}