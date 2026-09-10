class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k];
        freq[0] = 1;

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            int rem = prefixSum % k;

            if (rem < 0) {
                rem += k;
            }

            count += freq[rem];
            freq[rem]++;
        }

        return count;
    }
}