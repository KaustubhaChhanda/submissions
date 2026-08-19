class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();

        if (numRows == 1) {
            return s;
        }

        List<List<Character>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int index = 1;

        while (index < s.length()) {
            for (int i = 1; i < numRows && index < n; i++) {
                list.get(i).add(s.charAt(index++));
            }

            for (int i = numRows - 2; i >= 0 && index < n; i--) {
                list.get(i).add(s.charAt(index++));
            }
        }


        for (List<Character> l : list) {
            for (char ch : l) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}