class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 1) return strs[0];
        if (strs.length == 0) return "";
        
        Arrays.sort(strs);
        if (strs[0].isEmpty()) return "";
        if (strs[0].charAt(0) != strs[1].charAt(0)) return "";

        
        StringBuilder total = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean add = true;
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    add = false;
                    break;
                }
            }

            if (!add) break;
            total.append(c);
        }

        return total.toString();
    }
}