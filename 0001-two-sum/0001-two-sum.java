class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int need = target - nums[i];
            int idx = map.getOrDefault(need, -1);

            if (idx != -1 && idx != i) {
                return new int[]{ i, map.get(need) };
            }
        }

        return new int[]{ -1, -1 };
    }
}