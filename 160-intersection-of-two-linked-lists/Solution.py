from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    @classmethod
    def from_list(cls, values):
        if not values:
            raise ValueError("List must not be empty")

        head = cls(values[0])
        current = head
        for val in values[1:]:
            current.next = cls(val)
            current = current.next
        return head

    def __str__(self):
        result = []
        current = self
        while current:
            result.append(str(current.val))
            current = current.next
        return " -> ".join(result) + " -> None"

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        if headA is headB:
            return headA
        
        wallkerA = headA
        wallkerB = headB
        
        while wallkerA is not wallkerB:

            if wallkerA is None:
                wallkerA = headB
            else:
                wallkerA = wallkerA.next
            
            if wallkerB is None:
                wallkerB = headA
            else:
                wallkerB = wallkerB.next
        
        return wallkerA
    
nums = [1, 2, 3, 4]
head = ListNode.from_list(nums)

print(head)