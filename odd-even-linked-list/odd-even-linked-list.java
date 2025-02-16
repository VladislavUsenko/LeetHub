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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode runner = head.next, walker = head, runnerNext, walkerNext;

        while (runner != null && runner.next != null) {

            runnerNext = runner.next;
            walkerNext = walker.next;

            walker.next = runnerNext;
            runner.next = runnerNext.next;
            runnerNext.next = walkerNext;

            walker = runnerNext;

            runner = runner.next;
        }

        return head;
    }
}