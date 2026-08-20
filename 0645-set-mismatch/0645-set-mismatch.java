class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int duplicate = 0;

        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = num;
            } else {
                set.add(num);
                sum += num;
            }
        }

        int z = n * (n + 1) / 2;
        return new int[]{duplicate, z - sum};
    }
}