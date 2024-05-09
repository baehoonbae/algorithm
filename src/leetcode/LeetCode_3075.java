package leetcode;

import java.util.Arrays;

// 문제 링크: https://leetcode.com/problems/maximize-happiness-of-selected-children/description/
// 3075. Maximize Happiness of Selected Children
// 문제 요약: 배열 happiness와 정수 k가 주어질 때, 배열에서 k개의 요소를 선택하여 선택한 요소들의 합을 최대화하는 문제. 단 아이를 선택할 때마다 다른 요소들은 1씩 감소한다.

// 알고리즘: 그리디, 정렬
// 시간 복잡도: O(nlogn)
// 공간 복잡도: O(1)

// 풀이
// 1. 합을 최대화 하려면 가장 큰 값부터 더해야 함. 따라서 배열을 정렬하고 뒤에서부터 k개의 요소를 선택한다.
// 2. 선택할 때마다 다른 요소들은 1씩 감소하므로 discount 변수를 사용하여 감소된 값을 빼준다.
// 3. 선택한 요소들의 합을 반환한다.

public class LeetCode_3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length - 1;
        int sum = 0;
        int discount = 0;
        Arrays.sort(happiness);
        for (int i = n; i >= 0; i--, k--) {
            if (k == 0) {
                break;
            }
            if (happiness[i] - discount >= 0) {
                sum += happiness[i] - discount;
                discount++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode_3075 solution = new LeetCode_3075();
        int[] happiness = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(solution.maximumHappinessSum(happiness, k));
    }
}
