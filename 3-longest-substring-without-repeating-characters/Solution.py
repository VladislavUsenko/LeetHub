class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)==1:
            return 1
        d={}
        l,r = 0,0
        n = len(s)
        maxLen = 0
        while(r < n):
            if s[r] in d:
                l = max(l,d[s[r]]+1)
            length = r - l +1
            maxLen = max(maxLen,length)
            d[s[r]]=r
            r+=1
        return maxLen
    
str = "abcabcbb"
obj = Solution()

print(obj.lengthOfLongestSubstring(str))