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
    public ListNode swapPairs(ListNode head) {
        
        ListNode result = new ListNode(0, head);
        ListNode pre = result;
        while (head != null && head.next != null) {
            ListNode sec = head.next;
            head.next = sec.next;
            sec.next = head;
            pre.next = sec;
            pre = head;
            head = head.next;
        }

        return result.next;
    }
}