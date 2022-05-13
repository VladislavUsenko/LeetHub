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

        TreeMap<Integer, Integer> numsMap = new TreeMap<>();
        int count = 0;
        boolean node = false;
        for (int i: nums) {
            numsMap.put(i,0);
        }

        while (head != null) {
            if (numsMap.containsKey(head.val) && !node) {
                node = true;
                count++;
            }

            if (!numsMap.containsKey(head.val)) node = false;

            head = head.next;
        }

        return count;
    }
}