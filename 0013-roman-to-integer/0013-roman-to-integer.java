class Solution {
    public int romanToInt(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char prev = i > 0 ? s.charAt(i - 1) : '0';

            switch (ch) {
                case 'I':
                    res += 1;
                    break;

                case 'V':
                    if (prev == 'I') {
                        res += 3;
                    } else {
                        res += 5;
                    }

                    break;

                case 'X':
                    if (prev == 'I') {
                        res += 8;
                    } else {
                        res += 10;
                    }

                    break;

                case 'L':
                    if (prev == 'X') {
                        res += 30;
                    } else {
                        res += 50;
                    }

                    break;

                case 'C':
                    if (prev == 'X') {
                        res += 80;
                    } else {
                        res += 100;
                    }

                    break;

                case 'D':
                    if (prev == 'C') {
                        res += 300;
                    } else {
                        res += 500;
                    }

                    break;

                case 'M':
                    if (prev == 'C') {
                        res += 800;
                    } else {
                        res += 1000;
                    }
                    
                    break;
            }
        }

        return res;
    }
}