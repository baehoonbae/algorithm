package leetcode;

import libraries.list.ListNode;

// 문제 링크: https://leetcode.com/problems/reorder-list/submissions/1211313116/
// 143. Reorder List

// Runtime: 2 ms
// Memory: 46.57 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 연결 리스트, 투 포인터

public class LeetCode_143 {
    public void reorderList(ListNode head) {
        int[] arr = new int[50001];
        int size = 0;
        ListNode current = head;

        while (current != null) {
            arr[size] = current.val;
            current = current.next;
            size++;
        }

        boolean isLeft = true;
        int left = 0;
        int right = size - 1;

        while (head != null) {
            if (isLeft) {
                head.val = arr[left];
                isLeft= false;
                left++;
            } else {
                head.val = arr[right];
                isLeft=true;
                right--;
            }
            head = head.next;
        }
    }

}
