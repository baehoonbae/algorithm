package leetcode;

import libraries.list.SinglyLinkedListNode;

// 141. Linked List Cycle

// Runtime: 0 ms
// Memory: 44.14 MB
// TC: O(n)
// SC: O(1)

public class LeetCode_141 {
    public boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        SinglyLinkedListNode prev = head;
        SinglyLinkedListNode current = head;
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
