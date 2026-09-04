class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[index++]);
            int temp = index;
            int length = sb.length();
            int count = 0;

            while (temp < words.length && (length + words[temp].length() + 1) <= maxWidth) {
                length += words[temp++].length() + 1;
                count++;
            }

            if (count == 0) {
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

                list.add(sb.toString());
                continue;
            }

            if (temp >= words.length) {
                while (index < words.length) {
                    sb.append(" ");
                    sb.append(words[index++]);
                }

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

                list.add(sb.toString());

                break;
            }

            int spaces = maxWidth - length;
            int div = 0;
            int rem = 0;

            if (spaces != 0 && count != 0) {
                div = spaces / count;
                rem = spaces % count;
            }

            for (int w = 0; w < count; w++) {
                for (int i = 0; i <= div; i++) {
                    sb.append(" ");
                }

                if (rem > 0) {
                    sb.append(" ");
                    rem--;
                }

                sb.append(words[index]);
                index++;
            }

            if (sb.length() < maxWidth) {
                for (int i = 0; i <= maxWidth - sb.length(); i++) {
                    sb.append(" ");
                }
            }

            list.add(sb.toString());
        }

        return list;
    }
}