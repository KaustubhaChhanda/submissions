class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        
        int index = 1;

        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 1] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        int k = 1;

        for (int i = 1; i <= index; i++) {
            if (nums[i] != nums[i - 1]) {
                k++;
            }
        }

        return index + 1;
    }
}