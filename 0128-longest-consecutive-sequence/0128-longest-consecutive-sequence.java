class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> done = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxSequence = 0;

        for (int x : set) {
            if (done.contains(x)) {
                continue;
            }

            int length = 0;
            while (set.contains(x++)) {
                length++;
                done.add(x);
            }

            maxSequence = Math.max(maxSequence, length);
        }

        return maxSequence;
    }
}