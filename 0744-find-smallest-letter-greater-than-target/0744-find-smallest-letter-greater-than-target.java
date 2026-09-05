class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        int index = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] == target) {
                low = mid + 1;
            } else if (letters[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (low < letters.length) ? letters[low] : letters[0];
    }
}