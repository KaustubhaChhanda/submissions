class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> am = new HashMap<>();
        Map<Integer, Integer> vm = new HashMap<>();

        for (int num : nums) {
            am.put(num, am.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (am.get(num) == 0) {
                continue;
            }

            if (vm.containsKey(num)) {
                int freq = vm.get(num);

                if (freq == 1) {
                    vm.remove(num);
                } else {
                    vm.put(num, freq - 1);
                }

                vm.put(num + 1, vm.getOrDefault(num + 1, 0) + 1);
                am.put(num, am.get(num) - 1);
            } else if (am.getOrDefault(num + 1, 0) > 0 && am.getOrDefault(num + 2, 0) > 0) {

                am.put(num, am.get(num) - 1);
                am.put(num + 1, am.get(num + 1) - 1);
                am.put(num + 2, am.get(num + 2) - 1);

                vm.put(num + 3, vm.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}