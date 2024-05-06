package leetcode;

import libraries.list.ListNode;
import java.util.Stack;

// 문제 링크: https://leetcode.com/problems/remove-nodes-from-linked-list/description/
// 2487. Remove Nodes From Linked List
// 문제 요약: 주어진 연결 리스트에서 특정 조건을 만족하는 노드들을 제거하는 문제

// 알고리즘: 모노토닉 스택, 연결 리스트
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 이 문제의 핵심은 연결 리스트를 순회하면서 각 값을 스택에 넣다가 스택의 top 값보다 큰 값이 나오면 스택의 top 값보다 큰 값이 나올 때까지 스택에서 값을 빼내는 것
// 2. 이렇게 하게 되면 스택에는 무조건 내림차순으로 정렬된 값들이 들어가게 된다.
// 3. 이제 스택에 남은 값들을 연결 리스트로 만들어서 맨 앞의 값을 반환하면 된다.

public class LeetCode_2487 {
    public ListNode removeNodes(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();

        while (cur != null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();
            }
            stack.push(cur);
            cur = cur.next;
        }
        ListNode next = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            cur.next = next;
            next = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        LeetCode_2487 obj = new LeetCode_2487();
        ListNode res = obj.removeNodes(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
