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
        
        //if( null==headA || null==headB ) return null;
        if (headA == headB) return headA;
        
        ListNode walkerA = headA;
        ListNode walkerB = headB;
        
        while (walkerA != walkerB) {

            if (walkerA == null) {
                walkerA = headB;
            } else {
                walkerA = walkerA.next;
            }

            if (walkerB == null) {
                walkerB = headA;
            } else {
                walkerB = walkerB.next;
            }
        }
        return walkerA;
    }
}