class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        int count = 0;

        for (String word : words) {
            int prevIndex = -1;
            boolean isSequence = true;

            for (char ch : word.toCharArray()) {
                int index = binarySearch(map.get(ch), prevIndex);

                if (index != -1) {
                    prevIndex = index;
                } else {
                    isSequence = false;
                    break;
                }
            }

            if (isSequence) {
                count++;
            }
        }

        return count;
    }

    private int binarySearch(List<Integer> list, int target) {
        if (list == null) {
            return -1;
        }
        
        int low = 0, high = list.size() - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                index = list.get(mid);
                high = mid - 1;
            }
        }

        return index;
    }
}