package leetcode;

import java.util.Arrays;

// 문제 링크: https://leetcode.com/problems/boats-to-save-people/
// 881. Boats to Save People
// 문제 요약: 사람들의 몸무게와 보트의 무게 제한이 주어졌을 때, 모든 사람을 구출하기 위해 필요한 보트의 최소 개수를 구하는 문제

// 알고리즘: 투 포인터, 그리디
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)

// 풀이
// 1. 이 문제의 핵심은 가장 무거운 사람을 먼저 보내야 한다는 것이다.
// 2. 따라서 가장 무거운 사람을 먼저 태워놓고 가장 가벼운 사람을 태울 수 있는지 확인하면 그게 최소 보트의 개수가 될 것이다.
// 3. 우선 사람들의 몸무게를 오름차순으로 정렬
// 4. 가장 가벼운 사람(left)과 가장 무거운 사람(right)을 같이 태울 수 있는지 확인하고, 무게 제한을 초과하면 무거운 사람만 태워서 보낸다.
// 5. 무게 제한을 초과하지 않는다면 두 사람을 같이 태워서 보낸다.
// 6. 이 과정을 모든 사람을 구출할 때까지 반복하면서 보트의 개수를 세고 반환한다.

public class LeetCode_881 {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                count++;
                right--;
                continue;
            }
            count++;
            left++;
            right--;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode_881 c = new LeetCode_881();
        int[] people = {1,1,1,1};
        int limit = 4;

        System.out.println(c.numRescueBoats(people, limit));
    }
}
