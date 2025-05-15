from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        pair_idx = {}

        for i, num in enumerate(nums):
            if target - num in pair_idx:
                return [i, pair_idx[target - num]]
            pair_idx[num] = i

nums = [3,2,6]

target = 5

obj = Solution()
print(obj.twoSum(nums, target))