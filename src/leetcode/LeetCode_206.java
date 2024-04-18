package leetcode;

import libraries.list.ListNode;

// 문제 링크: https://leetcode.com/problems/reverse-linked-list/description/
// 206. Reverse Linked List

// Runtime: 0 ms
// Memory: 42.26 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 연결 리스트

public class LeetCode_206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;
    }
}

