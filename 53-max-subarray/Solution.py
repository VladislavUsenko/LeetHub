from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:

        res = nums[0]
        lastMax = nums[0]

        for i in range(1, len(nums)):

            lastMax = max(lastMax + nums[i], nums[i])
            res = max(res, lastMax)

        return res


nums = [-2,1,-3,4,-1,2,1,-5,4]

s = Solution()
res = s.maxSubArray(nums)

print(res)