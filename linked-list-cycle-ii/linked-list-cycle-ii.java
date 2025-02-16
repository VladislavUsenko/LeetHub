/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {

                ListNode newWalker = head;

                while (newWalker != walker) {
                    walker = walker.next;
                    newWalker = newWalker.next;
                }

                return newWalker;
            }
        }

        return null;
    }
}