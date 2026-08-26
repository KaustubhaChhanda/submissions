class Solution {
    class CharFreq {
        char ch;
        int freq;

        CharFreq(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<CharFreq> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (char key : map.keySet()) {
            if (map.get(key) > (s.length() + 1) / 2) {
                return "";
            }

            pq.offer(new CharFreq(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            CharFreq first = pq.poll();
            CharFreq second = pq.poll();

            sb.append(first.ch);
            sb.append(second.ch);

            if (first.freq - 1 != 0) {
                first.freq--;
                pq.offer(first);
            }

            if (second.freq - 1 != 0) {
                second.freq--;
                pq.offer(second);
            }
        }

        if (!pq.isEmpty()) {
            sb.append(pq.poll().ch);
        }

        return sb.toString();
    }
}