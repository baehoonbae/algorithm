package leetcode;

import libraries.list.ListNode;

// 문제 링크: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/
// 2816. Double a Number Represented as a Linked List
// 문제 요약: 링크드 리스트로 주어진 숫자를 2배로 만들고 각 숫자들을 연결 리스트로 만들어 반환하는 문제

// 알고리즘: 연결 리스트, 수학
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)

// 풀이
// 1. 곱셈이 이루어지는 알고리즘을 파악하는 것이 핵심이다.
// 2. 각 자리수를 2배로 만들어주고, 10이 넘어가면 다음 자리수에 1을 더해주는 방식이다.
// 3. 2배를 할 때 새로운 자릿수가 생겨나는 경우를 생각해서 맨 앞에 dummy 노드를 추가한다
// 4. 각 노드를 순회하면서, 현재 노드의 2배를 한 값이 10이 넘어가면 이전 노드에 1을 더해주고 현재 노드의 값을 10으로 나눈 나머지로 바꿔준다.

public class LeetCode_2816 {
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val * 2 >= 10) {
                prev.val += 1;
            }
            cur.val = (cur.val * 2) % 10;
            prev = prev.next;
            cur = cur.next;
        }
        return dummy.val > 0 ? dummy : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        LeetCode_2816 obj = new LeetCode_2816();
        ListNode res = obj.doubleIt(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
