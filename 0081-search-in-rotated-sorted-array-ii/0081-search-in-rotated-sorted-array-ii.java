class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        System.out.println(pivot);

        return binarySearch(nums, target, 0, pivot - 1) || binarySearch(nums, target, pivot, nums.length - 1);
    }

    private int findPivot(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                if (nums[low] == nums[mid]) {
                    if (nums[low] > nums[low + 1]) {
                        return low + 1;
                    }

                    low++;

                    if (nums[high] < nums[high - 1]) {
                        return high;
                    }

                    high--;
                } else {
                    high = mid;
                }
            }
        }

        return low;
    }

    private boolean binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true; 
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}