package leetcode;

// 문제 링크: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/
// 2997. Minimum Number of Operations to Make Array XOR Equal to K
// 문제 요약: 배열의 부분 요소의 비트를 변경한 후 배열의 모든 요소의 XOR 결과가 k가 되도록 하는 최소 연산 횟수를 구하는 문제

// 알고리즘: 비트 연산, DP
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)

// 풀이
// 1. XOR 연산의 특성상 a ^ b = c 이면 a ^ c = b, b ^ c = a 라는 교환 법칙이 성립한다.
// 2. 배열의 모든 요소의 XOR 결과를 n 이라고 하자
// 3. 예를 들어 요소가 [a,b,c,d] 인 배열이 있다면, a ^ b ^ c ^ d = n 일 때, n ^ a ^ b ^ c = d 이다
// 4. 이 말은 즉 n 만 적절히 변경해도 k 를 만들 수 있다는 이야기이다.
// 5. 따라서 n과 k의 XOR 결과의 1의 개수를 구하면 n을 k로 만들기 위한 최소 연산 횟수를 구할 수 있다.

public class LeetCode_2997 {
    public int minOperations(int[] nums, int k) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        n ^= k;
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        LeetCode_2997 solution = new LeetCode_2997();
        int[] nums = {4};
        int k = 7;
        int result = solution.minOperations(nums, k);
        System.out.println(result);
    }
}
