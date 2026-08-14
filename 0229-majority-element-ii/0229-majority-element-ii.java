class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE, score1 = 0, score2 = 0;

        for (int num : nums) {
            if (num == e1) {
                score1++;
            } else if (num == e2) {
                score2++;
            } else if (score1 == 0) {
                e1 = num;
                score1 = 1;
            } else if (score2 == 0) {
                e2 = num;
                score2 = 1;
            } else {
                score1--;
                score2--;
            }
        }

        int f1 = 0, f2 = 0;
        for (int num : nums) {
            if (num == e1) {
                f1++;
            } else if (num == e2) {
                f2++;
            }
        }

        List<Integer> list = new ArrayList<>();

        if (f1 > nums.length / 3) {
            list.add(e1);
        }

        if (f2  > nums.length / 3) {
            list.add(e2);
        }

        return list;
    }
}