import sys


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if(len(t) > len(s)): return ""

        n = len(s)

        map = {}

        for ch in t:
            if ch in map:
                map[ch] += 1
            else:
                map[ch] = 1
        
        print(map)

        end, begin, head = 0,0,0
        count = len(map)
        minLen = sys.maxsize

        while end < n:

            c = s[end]

            if(c in map):
                map[c] -= 1
                if map[c] == 0:
                    count -= 1

            end += 1
            print(map)
            print(begin, head, end)
            while count == 0:

                curLen = end - begin
                if (curLen < minLen):
                    head = begin
                    minLen = curLen
                
                c = s[begin]

                if c in map:
                    map[c] += 1
                    if map[c] > 0:
                        count += 1

                begin += 1

        if minLen == sys.maxsize:
            return ""
        else:
            return s[head:head + minLen] 



obj = Solution()

res = obj.minWindow("AA", "AA")

print(res)

