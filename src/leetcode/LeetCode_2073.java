package leetcode;

// 문제 링크: https://leetcode.com/problems/time-required-to-buy-n-items/
// 2073. Time Required to Buy N Items
// 문제 요약: n개의 티켓을 가진 배열이 주어지고 k번째 티켓을 구매하는데 걸리는 시간을 구하는 문제.

// 알고리즘: 시뮬레이션
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)

// 풀이
// 1. idx와 count를 0으로 초기화한다.
// 2. 티켓 배열의 k번째 티켓이 0이면 반복문을 종료한다.
// 3. idx번째 티켓이 0이면 idx를 1 증가시키고 다음 티켓을 확인한다.
// 4. 티켓을 구매하고 count를 1 증가시킨다.
// 5. idx를 1 증가시키고 다음 티켓을 확인한다.
// 6. 2~5을 반복한다.

public class LeetCode_2073 {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int idx = 0;
        int count = 0;
        while (true) {
            if (tickets[k] == 0) {
                break;
            }
            if (tickets[idx % n] == 0) {
                idx++;
                continue;
            }
            tickets[idx % n]--;
            count++;
            idx++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] tickets = {2, 6, 3, 4, 5};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }
}

