class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxSequence = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 0;

                while (set.contains(num)) {
                    length++;
                    num++;
                }

                maxSequence = Math.max(maxSequence, length);
            }
        }

        return maxSequence;
    }
}