class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return;
        }

        int index = -1;
        int k = -1;
        
        do {
            index++;
            
            if (nums[index] < nums[index + 1]) {
                k = index;
            }
        } while (index < n - 2);

        if (k == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        index = k;
        int l = k;

        do {
            index++;

            if (nums[k] < nums[index]) {
                l = index;
            }
        } while (index < n - 1);

        if (k != l) {
            int temp = nums[k];
            nums[k] = nums[l];
            nums[l] = temp;
        }

        reverse(nums, k + 1, n - 1);
        return;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}