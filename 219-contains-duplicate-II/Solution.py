from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        map = {}

        for idx in range(0,n):

            if nums[idx] in map:
                if idx - map[nums[idx]] <= k:
                    return True
                
            map[nums[idx]] = idx
        
        return False

arr = [1,2,3,1]

obj = Solution()

print(obj.containsNearbyDuplicate(arr, 3))

