class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] pre = new int[n];
        pre[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int prefix = i > 0 ? pre[i - 1] : 1;
            int suffix = i < n - 1 ? suf[i + 1] : 1;

            ans[i] = prefix * suffix;
        }

        return ans;
    }
}