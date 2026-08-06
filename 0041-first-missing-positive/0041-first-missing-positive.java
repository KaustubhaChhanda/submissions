class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                while (nums[i] != 0 && nums[i] != nums[nums[i] - 1]) {
                    int num = nums[i];
                    int index = num - 1;

                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
            }
        }

        int firstMissing = 0;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == 0 || nums[i - 1] != i) {
                firstMissing = i;
                break;
            }
        }

        return firstMissing == 0 ? n + 1 : firstMissing;
    }
}