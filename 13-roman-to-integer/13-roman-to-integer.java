class Solution {
    public int romanToInt(String s) {
        int[] map = new int[256];
        map['I'] = 1; map['V'] = 5; map['X'] = 10; map['L'] = 50; map['C'] = 100; map['D'] = 500; map['M'] = 1000;
        
        int ret = 0, pre = 1;
        for (int i = s.length()-1; i >= 0; --i) {
            int cur = map[s.charAt(i)];
            if (cur < pre) ret -= cur;
            else {
                pre = cur;
                ret += cur;
            }
        }
        return ret;
    }
}