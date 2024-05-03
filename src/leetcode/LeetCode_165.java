package leetcode;

// 문제 링크: https://leetcode.com/problems/compare-version-numbers/
// 165. Compare Version Numbers
// 문제 요약: '.' 으로 구분된 두 버전 문자열이 주어질 때, 더 큰 버전을 반환하는 문제

// 알고리즘: 문자열, 투 포인터
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. '.' 으로 구분된 두 버전 문자열을 split 으로 나눠서 배열에 저장
// 2. 두 배열의 길이 중 작은 길이만큼 반복문을 돌면서 각 숫자를 비교하고, 두 숫자가 다른 경우 각 조건에 맞게 반환
// 3. 이 이후는 두 배열의 길이가 다른 경우인데, 길이가 더 긴 배열을 반복문을 돌면서 0이 아닌 숫자가 나올 경우 그 문자열의 버전이 더 크다는 의미가 된다.

public class LeetCode_165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int size = Math.min(v1.length, v2.length);
        for (int i = 0; i < size; i++) {
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[i]);
            if (a > b) return 1;
            if (a < b) return -1;
        }
        for (int i = size; i < v1.length; i++) {
            if (Integer.parseInt(v1[i]) != 0) return 1;
        }
        for (int i = size; i < v2.length; i++) {
            if (Integer.parseInt(v2[i]) != 0) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode_165 leetCode_165 = new LeetCode_165();
        System.out.println(leetCode_165.compareVersion("1.01", "1.001"));
    }
}
