class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        ans >>= 31;
        int pos = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                count += nums[j] & 1;
                nums[j] >>= 1;
            }

            ans ^= (count % 3) << pos++;
        }

        return ans;
    }
}