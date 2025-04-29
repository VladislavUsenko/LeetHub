from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    @staticmethod
    def deleteDuplicates(head: Optional[ListNode]) -> Optional[ListNode]:
        
        runner = head

        while runner is not None and runner.next is not None:
            if (runner.val == runner.next.val):
                runner.next = runner.next.next
            else:
                runner = runner.next
        
        return head