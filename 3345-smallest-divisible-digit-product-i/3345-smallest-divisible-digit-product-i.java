class Solution {
    public int smallestNumber(int n, int t) {
        for (int i = n; i < Integer.MAX_VALUE; i++) {
            if (getDigitsProduct(i) % t == 0) {
                return i;
            }
        }

        return -1;
    }

    private long getDigitsProduct(int num) {
        int prod = 1;
        while (num != 0) {
            prod *= num % 10;
            num /= 10;
        }

        return prod;
    }
}