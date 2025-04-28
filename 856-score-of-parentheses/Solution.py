

class Solution:
    
    def scoreOfParentheses(self, s: str) -> int:

        stack = []
        stack.append(0)

        for ch in s:
            if ch == '(':
                stack.append(0)
            else:
                last = stack.pop()
                top = stack.pop()

                stack.append(top + max(2 * last, 1))
        
        return stack.pop()
    
s = "(()(())())"
obj = Solution()

print(obj.scoreOfParentheses(s))