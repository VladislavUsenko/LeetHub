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
   public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        ListNode temp;

        int len = 1;
        for (temp = head; temp.next != null; temp = temp.next)
            len++;

        temp.next = head;

        for (int i = len - k % len; i > 1; i--)
            head = head.next;

        temp = head.next;
        head.next = null;

        return temp;
    }
}