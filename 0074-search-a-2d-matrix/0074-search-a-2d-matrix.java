class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = getRow(matrix, target);
        
        if (index == -1) {
            return false;
        }

        return doesExists(matrix[index], target);
    }

    private int getRow(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            } else if (target > matrix[mid][0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private boolean doesExists(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}