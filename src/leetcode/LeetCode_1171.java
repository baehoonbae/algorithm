package leetcode;

// 문제 링크: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/
// 1171. Remove Zero Sum Consecutive Nodes from Linked List

// Runtime: 3 ms
// Memory: 44.48 MB
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 분류: 해시맵, 연결 리스트


import libraries.list.*;

import java.util.*;

public class LeetCode_1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        map.put(0, dummy);

        while (head != null) {
            prefixSum += head.val;

            if (map.containsKey(prefixSum)) {
                ListNode start = map.get(prefixSum);
                ListNode temp = start;
                int sum = prefixSum;
                while (temp != head) {
                    temp = temp.next;
                    sum += temp.val;
                    if (temp != head)
                        map.remove(sum);
                }
                start.next = head.next;
            } else {
                map.put(prefixSum, head);
            }

            head = head.next;
        }
        return dummy.next;
    }
}

