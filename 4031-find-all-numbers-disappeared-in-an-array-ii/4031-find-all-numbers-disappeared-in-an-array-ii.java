class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = lower; i <= upper; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(list);

        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 1;

        while (i < list.size() && j < list.size()) {
            if ((list.get(j - 1) + 1) == list.get(j)) {
                j++;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(list.get(i));
                temp.add(list.get(j - 1));
                ans.add(temp);
                i = j;
                j++;
            }
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(i));
        temp.add(list.get(j - 1));
        ans.add(temp);

        return ans;
    }
}