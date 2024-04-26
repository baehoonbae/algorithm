package leetcode;

import libraries.list.ListNode;

// 19. Remove Nth Node From End of List

// Runtime: 0 ms
// Memory: 41.45 MB

// TC: O(n)
// SC: O(1)

public class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        int idx = 0;
        ListNode current = new ListNode(head.val, head.next);
        while (current.next != null) {
            current = current.next;
            size++;
        }
        if (size == n) {
            current = head.next;
            head = null;
            return current;
        }
        ListNode prev = new ListNode(head.val, head.next);
        current = head;
        while (idx != (size - n)) {
            prev = head;
            head = head.next;
            idx++;
        }
        prev.next = head.next;
        return current;
    }
}

