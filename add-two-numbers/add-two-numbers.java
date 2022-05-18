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
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int left = 0;
        ListNode dummy = new ListNode(0), tail = dummy;
        
        // iterate two list, add each position until 2 lists are finished && left equals to 0
        while(!(l1 == null && l2 == null && left == 0)){
            // is number1 finished?
            int add1 = l1 != null ? l1.val : 0;
            // is number2 finished?
            int add2 = l2 != null ? l2.val : 0;
            int sum = add1 + add2 + left;
            left = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            tail.next = newNode;
            tail = newNode;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}