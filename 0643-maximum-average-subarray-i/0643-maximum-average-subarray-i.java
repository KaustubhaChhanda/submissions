class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0, sum = 0;
        double maxAvg = -Double.MAX_VALUE;

        while (right < k - 1) {
            sum += nums[right++];
        }

        while (right < nums.length) {
            sum += nums[right++];
            double avg = (double) sum / k;

            if (avg > maxAvg) {
                maxAvg = avg;
            }

            sum -= nums[left++];
        }

        return maxAvg;
    }
}