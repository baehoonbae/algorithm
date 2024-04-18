package leetcode;

import libraries.list.ListNode;

// 876. Middle of the Linked List

// Runtime: 0 ms
// Memory: 40.76 MB
// TC: O(n)
// SC: O(1)

public class LeetCode_876 {
    public ListNode middleNode(ListNode head) {
        int size = 1;
        ListNode current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        int idx = 1;
        current = head;
        while (idx != (size / 2 + 1)) {
            idx++;
            current = current.next;
        }
        return current;
    }
}
