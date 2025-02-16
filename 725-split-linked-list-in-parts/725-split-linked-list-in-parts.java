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
    public ListNode[] splitListToParts(ListNode head, int k) {

        int headSize = 0;

        ListNode node = head;
        while (node != null) {
            node = node.next;
            headSize++;
        }

        double partSize = (double) headSize / (double) k;

        ListNode[] result = new ListNode[k];
        
        int index = 0;
        node = head;
        ListNode prev = null;

        while (node != null) {

            result[index] = node;
            int speed = headSize % k == 0 ? (int)partSize : (int)partSize + 1;

            for (int j = 0; j < speed; j++) {
                prev = node;
                node = node.next;
            }
            headSize = headSize - speed;
            k--;
            index++;
            prev.next = null;
        }

        return result;
    }
}