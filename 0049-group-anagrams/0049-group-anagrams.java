class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            map.computeIfAbsent(sort(s), k -> new ArrayList<>()).add(s);
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }

    private String sort(String s) {
        char[] string = s.toCharArray();
        Arrays.sort(string);
        return new String(string);
    }
}