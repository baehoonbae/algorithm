package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/reveal-cards-in-increasing-order/
// 950. Reveal Cards In Increasing Order
// 문제 요약: 카드 배열이 주어졌을 때, 특정 규칙을 적용하여 재정렬했을 때 오름차순으로 정렬되는 배열을 반환하는 문제이다.

// 알고리즘: 시뮬레이션, 구현, 덱
// 시간 복잡도: O(NlogN)
// 공간 복잡도: O(N)

// 풀이
// 1. 문제에서 주어진 특정 규칙은 다음과 같다.
//  - 카드를 맨 위에서 한장 뽑는다.
//  - 안 뽑은 카드 중 맨 위의 카드를 맨 뒤에 놓는다.
//  - 카드를 다 뽑을 때까지 반복한다.
// 2. 문제에서 요구하는 바는 규칙을 적용하여 오름차순으로 정렬된 배열을 반환하는 것이다.
// 3. 즉 오름차순으로 정렬된 배열을 규칙의 역순으로 적용하면 원래 배열이 나올 것이다.

public class LeetCode_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> answer = new ArrayDeque<>();
        Arrays.sort(deck);

        for (int i = deck.length - 1; i >= 0; i--) {
            if (!answer.isEmpty()) {
                answer.addFirst(answer.pollLast());
            }
            answer.addFirst(deck[i]);
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.pollFirst();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        LeetCode_950 solution = new LeetCode_950();
        System.out.println(Arrays.toString(solution.deckRevealedIncreasing(deck)));
    }
}