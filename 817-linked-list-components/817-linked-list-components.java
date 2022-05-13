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
    public int numComponents(ListNode head, int[] nums) {
        
        if (head == null) return 0;

        Set<Integer> numsSet = new HashSet<>();
        for (int i : nums) numsSet.add(i);

        int count = 0;
        boolean node = false;

        while (head != null) {
            if (numsSet.contains(head.val) && !node) {
                node = true;
                count++;
            }

            if (!numsSet.contains(head.val)) node = false;

            head = head.next;
        }

        return count;
    }
}