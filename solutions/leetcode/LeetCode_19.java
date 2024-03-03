package leetcode;

import libraries.list.SinglyLinkedListNode;

// 19. Remove Nth Node From End of List

// Runtime: 0 ms
// Memory: 41.45 MB
// TC: O(n)
// SC: O(1)

public class LeetCode_19 {
    public SinglyLinkedListNode removeNthFromEnd(SinglyLinkedListNode head, int n) {
        int size = 1;
        int idx = 0;
        SinglyLinkedListNode current = new SinglyLinkedListNode(head.val, head.next);
        while (current.next != null) {
            current = current.next;
            size++;
        }
        if (size == n) {
            current = head.next;
            head = null;
            return current;
        }
        SinglyLinkedListNode prev = new SinglyLinkedListNode(head.val, head.next);
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
