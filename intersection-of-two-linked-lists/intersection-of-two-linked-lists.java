/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == headB) return headA;

        while (headA != null) {

            ListNode tmp = headB;

            while (tmp != null) {
                if (headA == tmp) {
                    return headA;
                }
                tmp = tmp.next;
            }
            
            headA = headA.next;
        }
        return null;
    }
}