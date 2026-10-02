/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        List<String> newWords = new ArrayList<>(Arrays.asList(words));
        tryMatch(newWords, master);
    }

    private void tryMatch(List<String> words, Master master) {
        int length = words.size();

        if (length == 0) {
            return;
        }

        if (length == 1) {
            master.guess(words.get(0));
            return;
        }

        String word = chooseWord(words);

        int val = master.guess(word);

        List<String> newWords = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String other = words.get(i);

            if (word.equals(other)) {
                continue;
            }

            if (match(word, other) == val) {
                newWords.add(other);
            }
        }

        tryMatch(newWords, master);
    }

    private int match(String a, String b) {
        int count = 0;

        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private String chooseWord(List<String> words) {
        String bestWord = words.get(0);
        int bestScore = Integer.MAX_VALUE;

        for (String word : words) {
            int[] groups = new int[7];

            for (String other : words) {
                int matches = match(word, other);
                groups[matches]++;
            }

            int worstGroup = 0;

            for (int count : groups) {
                worstGroup = Math.max(worstGroup, count);
            }

            if (worstGroup < bestScore) {
                bestScore = worstGroup;
                bestWord = word;
            }
        }

        return bestWord;
    }
}