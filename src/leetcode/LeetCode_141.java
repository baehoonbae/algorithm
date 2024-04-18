package leetcode;

import libraries.list.ListNode;

// 141. Linked List Cycle

// Runtime: 0 ms
// Memory: 44.14 MB
// TC: O(n)
// SC: O(1)

public class LeetCode_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode prev = head;
        ListNode current = head;
        while (current != null && current.next != null) {
            prev = prev.next;
            current = current.next.next;
            if (prev == current) {
                return true;
            }
        }
        return false;
    }
}

