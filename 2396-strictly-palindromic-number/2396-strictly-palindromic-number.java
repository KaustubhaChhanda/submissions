class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int b = 2; b <= n - 2; b++) {
            if (!isPalindrome(n, b)) {
                return false;
            }
        }

        return true;
    }

    private boolean isPalindrome(int n, int base) {
        int[] digits = new int[32];
        int i = 0;

        while (n > 0) {
            digits[i++] = n % base;
            n /= base;
        }

        int left = 0;
        int right = i - 1;

        while (left < right) {
            if (digits[left] != digits[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}