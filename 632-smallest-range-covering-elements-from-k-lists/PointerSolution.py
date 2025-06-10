from typing import List

"""
    Approach:
        1. Finds the min and max among current elements from each list
        2. Tracks which list had the min value 
        3. Advances the pointer in that list only
        4. Updates the smallest range seen so far
        5. Terminates when any list is exhausted


    Time: O(K² * N) in worst case, where 
        -K is number of lists
        -N is average number of elements per list
    Space: O(k), where k is the number of lists

    Q/A:
    How much time have I spent, end-to-end?
    - 2 h 10 minutes:
        1. Underested the problem and find optimal solution [20 minutes]
        2. Coding my approach in Java [50 minutes]
        3. Coding heap approach in Java [40 minutes]
        4. Prepering final code in Python [20 minutes]
    
    What were the trickiest aspects? Where did you lose the most time?
    - most trickiest aspects - understanding how tracking pointers in each list; 
    - lost time mostly on polish pointer approach
    
    What are some lessons/insights I gained from this problem?
    - heap is beter then tracing pointers in for-loop
    
    What would I do differently if I had extra time? What’s remaining to improve?
    - I will try to solve in Java with Object solution (store val and indexes in object)
    
    What did I do well?
    - tracking pointers in each list
    
    Did you use any hints, if yes, what? (please do not give up and look up the hints quickly. if you do need to look up the hints, only use the ones given on the problem page one by one, and DON'T look at youtube videos or full solutions, until you try really hard)
    - 
        - asked GPT how improve pointers solution, it's told me about heap.

    How difficult was the problem (1 super trivial, 10 extremely difficult) (answer this question three times separately for a) implementing quickly b) finding the right approach c) overall)
    - 
        a) implementing quickly 4 
        b) finding the right approach 6
        c) overall 7

    What's the time & space complexity?
    -   Time: O(K² * N) in worst case, where 
            -K is number of lists
            -N is average number of elements per list
    -   Space: O(k), where k is the number of lists
"""

class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        k = len(nums)
        pointers = [0] * k
        
        min_range = 0
        max_range = 0
        min_diff = float('inf')

        while True:
            min_val = float('inf')
            max_val = float('-inf')
            min_idx = -1

            for i in range(k):
                if pointers[i] >= len(nums[i]):
                    return [min_range, max_range]

                val = nums[i][pointers[i]]
                if val < min_val:
                    min_val = val
                    min_idx = i
                max_val = max(max_val, val)

            if max_val - min_val < min_diff:
                min_diff = max_val - min_val
                min_range = min_val
                max_range = max_val

            pointers[min_idx] += 1
            if pointers[min_idx] == len(nums[min_idx]):
                break

        return [min_range, max_range]

nums = [
    [4, 10, 15, 24, 26],
    [0, 9, 12, 20],
    [5, 18, 22, 30]
]

sol = Solution()
print(sol.smallestRange(nums))