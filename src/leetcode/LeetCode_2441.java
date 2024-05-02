package leetcode;

import java.util.HashSet;
import java.util.Set;

// 문제 링크: https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/
// 2441. Largest Positive Integer That Exists With Its Negative
// 문제 요약: 주어진 배열에서 음수와 양수가 서로 존재하는 가장 큰 양수를 찾는 문제

// 알고리즘: 해시 테이블
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 음수를 저장할 해시 테이블 선언
// 2. 순회를 하면서 음수들을 해시 테이블에 저장하고, 양수를 순회하면서 해당 수의 음수가 있는지 확인
// 3. 해당 수의 음수가 존재한다면 최대값을 갱신해준다

public class LeetCode_2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int n = nums.length;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                s.add(nums[i]);
            }
        }
        boolean check = false;
        for (int i = 0; i < nums.length; i++) {
            if (s.contains(-nums[i])) {
                maxValue = Math.max(maxValue, nums[i]);
                check = true;
            }
        }
        return check ? maxValue : -1;
    }

    public static void main(String[] args) {
        LeetCode_2441 solution = new LeetCode_2441();
        int[] nums = {-10,8,6,7,-2,-3};
        System.out.println(solution.findMaxK(nums));
    }
}
