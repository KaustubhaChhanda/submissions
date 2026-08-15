class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int index =  0, length = 0;
        long count = 0;

        while (index < nums.length) {
            if (nums[index] == 0) {
                length++;
            } else if (length != 0) {
                count += ((long) length * (length  + 1)) / 2;
                length = 0;
            }

            index++;
        }

        if (length != 0) {
            count += ((long) length * (length + 1)) / 2;
        }

        return count;
    }
}