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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode runner = dummy;
        ListNode walker = dummy;

        runner = listRun(head, runner, n);

        while (runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }

        walker.next = walker.next.next;

        return dummy.next;
    }

    public ListNode listRun(
            ListNode head,
            ListNode runner,
            int n) {

        if (runner == null) {
            runner = head;
        }

        if (n == 0) {
            return runner;
        } else {
            return listRun(head, runner.next, --n);
        }
    }
}