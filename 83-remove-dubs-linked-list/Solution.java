/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode runner = head;

        while (runner != null && runner.next != null) {

            if (runner.val == runner.next.val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }

        }

        return head;
    }
}