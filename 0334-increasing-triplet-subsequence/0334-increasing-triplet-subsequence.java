class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] smallest = new int[n];
        int[] largest = new int[n];
        smallest[0] = nums[0];
        largest[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            smallest[i] = Math.min(smallest[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            largest[i] = Math.max(largest[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > smallest[i] && nums[i] < largest[i]) {
                return true;
            }
        }

        return false;
    }
}