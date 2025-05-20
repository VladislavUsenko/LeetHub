from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        result = []

        intervals.sort(key=lambda x: x[0])

        a = intervals[0][0]
        b = intervals[0][1]

        for interval in intervals:

            if interval[0] > b:
                result.append([a, b])
                a = interval[0]
                b = interval[1]
            elif interval[1] > b:
                b = interval[1]


        result.append([a, b])
            
        return result
    

intervals = [[1,3],[2,6],[8,10],[15,18]]

obj = Solution()
res = obj.merge(intervals)

print(res)