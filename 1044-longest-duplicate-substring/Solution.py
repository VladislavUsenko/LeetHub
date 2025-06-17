"""
    Approach:
        1. Finds the max length of future substring using binary search algorithm
        2. Use sliding window for finding frequency of occurrence
            a. if substring occured 2 times return result
            b. else decrise max length


    Q/A:
    How much time have I spent, end-to-end?
    - 2 h:
        1. Underested the problem and find optimal solution [30 minutes]
        2. Solving task 187. Repeated DNA Sequences [30 minutes]
        3. Coding, Debaging and finding better solution [60 minutes]
    
    What were the trickiest aspects? Where did you lose the most time?
    - most trickiest aspects - find the max lenght of  future substring; 
    - lost time mostly on finding better solution
    
    What are some lessons/insights I gained from this problem?
    - I will never understand the Rabin-Karp algorithm.
    
    What would I do differently if I had extra time? What's remaining to improve?
    - I will try sufix array approuch
    
    What did I do well?
    - Use sliding window for finding frequency of occurrence
    
    Did you use any hints, if yes, what? (please do not give up and look up the hints quickly. if you do need to look up the hints, only use the ones given on the problem page one by one, and DON'T look at youtube videos or full solutions, until you try really hard)
    - 
        - one hint from task discription how find the max length of future substring.

    How difficult was the problem (1 super trivial, 10 extremely difficult) (answer this question three times separately for a) implementing quickly b) finding the right approach c) overall)
    - 
        a) implementing quickly 4 
        b) finding the right approach 6
        c) overall 7

    What's the time & space complexity?
    -   Time: O(N^2 log N) in the worst case, where 
            -N length of string 
    -   Space: O(N) in the worst case
"""


class Solution:
    def longestDupSubstring(self, s: str) -> str:
        n = len(s)
        left, right = 1, n
        result = ""

        while left < right:
            mid = (left + right) // 2
            dup = self.get_duplicate(s, mid)
            if dup is not None:
                result = dup
                left = mid + 1
            else:
                right = mid

        return result

    def get_duplicate(self, s: str, L: int) -> str:
        seen = set()
        for i in range(len(s) - L + 1):
            substring = s[i:i+L]
            if substring in seen:
                return substring
            seen.add(substring)
        return None