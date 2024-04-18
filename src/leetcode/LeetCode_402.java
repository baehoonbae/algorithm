package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// 문제 링크: https://leetcode.com/problems/remove-k-digits/
// 402. Remove K Digits
// 문제 요약: 숫자에서 k개의 숫자를 제거했을 때 얻을 수 있는 가장 작은 숫자를 구하는 문제

// 알고리즘: 스택, 그리디
// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 풀이
// 1. 스택(덱)에 숫자를 하나씩 넣는다.
// 2. 다음 숫자가 스택의 맨 앞의 숫자보다 클 때까지 스택의 숫자를 제거한다.
// 3. 그러면 가장 높은 숫자를 최대한 작게 만들 수 있다.
// 4. k개의 숫자를 제거할 때까지 반복한다.
// 5. 만약 k개의 숫자를 제거하지 못했다면, 스택의 뒤에서부터 k개를 제거한다.
// 6. 맨 앞에 붙어있는 0을 모두 제거해주고 스택이 비어있다면 0을, 그렇지 않다면 스택을 문자열로 변환하여 반환한다.

public class LeetCode_402 {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> d = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !d.isEmpty() && d.getLast() > c) {
                d.pollLast();
                k--;
            }
            d.addLast(c);
        }
        while (k-- > 0) {
            d.pollLast();
        }
        while (true) {
            if (d.isEmpty() || d.getFirst() != '0') {
                break;
            }
            if (d.getFirst() == '0') {
                d.pollFirst();
            }
        }
        for (char c : d) {
            sb.append(c);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        LeetCode_402 solution = new LeetCode_402();
        System.out.println(solution.removeKdigits("1432219", 3)); // 1219
        System.out.println(solution.removeKdigits("10200", 1)); // 200
        System.out.println(solution.removeKdigits("112", 1)); // 0
    }
}
