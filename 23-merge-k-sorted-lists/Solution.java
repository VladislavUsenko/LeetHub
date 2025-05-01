import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,4,5};
        int[] nums2 = {0,2};
        int[] nums3 = {2,6};
        int[] nums4 = {7,8,9};
        int[] nums5 = {-1, 0, 0};

        ListNode[] lists = {
            new ListNode(nums1),
            new ListNode(nums2),
            new ListNode(nums3),
            new ListNode(nums4),
            new ListNode(nums5)
        };

        System.out.println("--------------------");
        System.out.println(
            mergeKLists(lists)
        );

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;

        Queue<ListNode> queue = new LinkedList<>();

        for (ListNode node : lists) {
            queue.add(node);
        }

        while (queue.size() > 1) {
            queue.add(
                mergeTwoLists(
                    queue.poll(),
                    queue.poll()
                )
            );
        }

        return queue.peek();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}