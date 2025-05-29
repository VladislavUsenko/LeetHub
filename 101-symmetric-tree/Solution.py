

from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isMirror(root, root)
    
    def isMirror(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:

        if not left or not right:
            return left == right
        
        if left.val == right.val:
            return self.isMirror(left.left, right.right) and self.isMirror(left.right, right.left)
        
        return False
    
root = TreeNode(
    1,
    TreeNode(2),
    TreeNode(2)
)

obj = Solution()

print(obj.isSymmetric(root))