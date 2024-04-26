package leetcode;

import libraries.list.ListNode;

// 문제 링크: https://leetcode.com/problems/merge-in-between-linked-lists/description/
// 1669. Merge In Between Linked Lists

// Runtime: 1 ms
// Memory: 46.76 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 연결 리스트, 투 포인터

public class LeetCode_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        ListNode end = list1;
        ListNode current = start;
        int x = 0, y = 0;

        while (x < a - 1) {
            start = start.next;
            x++;
        }
        while (y < b) {
            end = end.next;
            y++;
        }

        start.next = list2;
        ListNode temp = list2;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = end.next;

        return current;
    }
}