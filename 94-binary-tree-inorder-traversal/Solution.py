
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

        
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        result = []
        self.traveler(root, result)

        return result

    def traveler(self, root: Optional[TreeNode], result: List[int]):

        if root is not None:
            self.traveler(root.left, result)
            result.append(root.val)
            self.traveler(root.right, result)

root = TreeNode(1, TreeNode(2), TreeNode(3))

obj = Solution()

print(obj.inorderTraversal(root))

