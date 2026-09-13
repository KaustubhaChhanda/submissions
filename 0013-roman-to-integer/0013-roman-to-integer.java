class Solution {
    public int romanToInt(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char prev = i > 0 ? s.charAt(i - 1) : '0';

            if (ch == 'I') {
                res += 1;
            } else if (ch == 'V') {
                if (prev == 'I') {
                    res += 3;
                } else {
                    res += 5;
                }
            } else if (ch == 'X') {
                if (prev == 'I') {
                    res += 8;
                } else {
                    res += 10;
                }
            } else if (ch == 'L') {
                if (prev == 'X') {
                    res += 30;
                } else {
                    res += 50;
                }
            } else if (ch == 'C') {
                if (prev == 'X') {
                    res += 80;
                } else {
                    res += 100;
                }
            } else if (ch == 'D') {
                if (prev == 'C') {
                    res += 300;
                } else {
                    res += 500;
                }
            } else {
                if (prev == 'C') {
                    res += 800;
                } else {
                    res += 1000;
                }
            }
        }

        return res;
    }
}