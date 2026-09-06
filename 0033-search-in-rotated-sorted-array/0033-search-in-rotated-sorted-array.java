class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int index = binarySearch(nums, target, 0, pivot - 1);

        return (index != -1) ? index : binarySearch(nums, target, pivot, nums.length - 1);
    }

    private int findPivot(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}