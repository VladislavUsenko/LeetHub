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
   public boolean isPalindrome(ListNode head) {

        ListNode walker = head, runner = head;

        while (runner != null && runner.next != null) {

            runner = runner.next.next;
            walker = walker.next;
        }

        if (runner != null) walker = walker.next;

        walker = reverseList(walker);
        runner = head;

        while (walker != null) {
            if (runner.val != walker.val) return false;

            runner = runner.next;
            walker = walker.next;
        }

        return true;
    }
    
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode next, prev = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}