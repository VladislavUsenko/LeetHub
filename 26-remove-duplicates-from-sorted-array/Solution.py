from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:

        j = 0
        for i in range(1, len(nums)):

            if(nums[i] != nums[i - 1]):
                j += 1
            print(i, nums[i])

        return j


nums = [0,0,1,1,1,2,2,3,3,4]
res = Solution.removeDuplicates(Solution, nums)

print("res =", res)

