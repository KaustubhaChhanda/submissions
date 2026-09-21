class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0] % 2 == 0 ? 0 : 1;

        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + (nums[i] % 2 == 0 ? 0 : 1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(pre[i] - k)) {
                count += map.get(pre[i] - k);
            }

            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }

        return count;
    }
}