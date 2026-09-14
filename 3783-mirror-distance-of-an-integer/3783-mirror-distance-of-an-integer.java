class Solution {
    public int mirrorDistance(int n) {
        int m = 0, temp = n;

        while (temp != 0) {
            m *= 10;
            m += temp % 10;
            temp /= 10;
        }

        return Math.abs(n - m);
    }
}