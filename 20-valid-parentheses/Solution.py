class Solution:
    def isValid(self, s: str) -> bool:

        stack = []

        for c in s:
            match c:
                case '(':
                    stack.append(')')
                case '{':
                    stack.append('}')
                case '[':
                    stack.append(']')
                case _:
                    if not stack or stack.pop() != c:
                        return False
                    
        return not stack