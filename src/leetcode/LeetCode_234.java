package leetcode;

import libraries.list.ListNode;

// 문제 링크: https://leetcode.com/problems/palindrome-linked-list/description/
// 234. Palindrome Linked List

// Runtime: 5 ms
// Memory: 56.01 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 연결 리스트, 투 포인터

public class LeetCode_234 {
    public boolean isPalindrome(ListNode head) {
        int[] arr = new int[100001];
        int size = 0;
        while (head != null) {
            arr[size] = head.val;
            head = head.next;
            size++;
        }
        int start = 0;
        int end = size - 1;
        while (start < end && arr[start] == arr[end]) {
            start++;
            end--;
        }
        return start >= end;
    }
}
