class Solution {
    public String countAndSay(int n) {
        return dfs(n);
    }

    private String dfs(int n) {
        if (n == 1) {
            return "1";
        }

        String s = dfs(n - 1);
        StringBuilder sb = new StringBuilder();

        int index = 0;
        
        while (index < s.length()) {
            char ch = s.charAt(index);
            int count = 0;

            do {
                count++;
                index++;
            } while (index < s.length() && s.charAt(index) == ch);

            sb.append("" + count + ch);
        }

        return sb.toString();
    }
}