package leetcode;

import libraries.list.ListNode;

// 문제 링크: https://leetcode.com/problems/delete-node-in-a-linked-list/
// 237. Delete Node in a Linked List
// 문제 요약: 주어진 노드의 값에 해당하는 노드를 삭제하는 문제

// 알고리즘: 연결 리스트
// 시간 복잡도: O(1)
// 공간 복잡도: O(1)

// 풀이
// 1. 주어진 노드의 값을 다음 노드의 값으로 바꾼다.
// 2. 주어진 노드의 다음 노드를, 주어진 노드의 다음 다음 노드로 바꾼다.

public class LeetCode_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        LeetCode_237 solution = new LeetCode_237();
        solution.deleteNode(head.next.next);
        System.out.println(head);
    }
}
