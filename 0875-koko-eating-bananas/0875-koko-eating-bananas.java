class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int p : piles) {
            max = Math.max(max, p);
        }

        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int d = diff(piles, mid, h);

            if (d >= 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int diff(int[] piles, int speed, int h) {
        int count = 0;

        for (int p : piles) {
            count += p / speed;

            if (p % speed != 0) {
                count++;
            }
        }

        return h - count;
    }
}