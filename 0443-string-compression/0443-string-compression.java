class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int count = 0;
        Character prev = null;

        for (char ch : chars) {
            if (prev != null) {
                if (prev == ch) {
                    count++;
                } else {
                    if (count == 1) {
                        chars[index++] = prev;
                    } else {
                        chars[index++] = prev;
                        
                        for (char digit : String.valueOf(count).toCharArray()) {
                            chars[index++] = digit;
                        }
                    }

                    count = 1;
                    prev = ch;
                }
            } else {
                count = 1;
                prev = ch;
            }
        }

        if (count == 1) {
            chars[index++] = prev;
        } else {
            chars[index++] = prev;
            
            for (char digit : String.valueOf(count).toCharArray()) {
                chars[index++] = digit;
            }
        }

        return index;
    }
}