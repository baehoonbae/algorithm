package leetcode;

// 문제 링크: https://leetcode.com/problems/trapping-rain-water/
// 42. Trapping Rain Water
// 문제 요약: 높이가 주어진 배열에서 빗물이 고이는 양을 구하는 문제.

// 알고리즘: 투 포인터, 스택, 그리디
// 시간 복잡도: O(N)
// 공간 복잡도: O(1)

// 풀이
// 1. 높이가 가장 높은 기둥을 찾아서 기준으로 삼는다.
// 2. 그 기둥을 기준으로 왼쪽과 오른쪽을 나눈다.
// 3. 왼쪽은 0부터 기준 인덱스까지, 오른쪽은 끝에서부터 기준 인덱스까지 루프를 돌면서 물이 고였을 때의 다각형의 넓이를 구한다.
// 4. 그 다각형의 넓이에서 기둥의 높이를 빼면 물이 고인 양이 된다.

public class LeetCode_42 {
    public int trap(int[] height) {
        int standardIdx = 0;
        int standardHeight = 0;
        int leftMax = 0;
        int rightMax = 0;
        int area = 0;

        for (int i = 0; i < height.length; i++) {
            if (standardHeight < height[i]) {
                standardHeight = height[i];
                standardIdx = i;
            }
        }
        area += standardHeight;
        for (int i = 0; i < standardIdx; i++) {
            leftMax = Math.max(leftMax, height[i]);
            area += leftMax;
        }
        for (int i = height.length - 1; i > standardIdx; i--) {
            rightMax = Math.max(rightMax, height[i]);
            area += rightMax;
        }
        for (int j : height) {
            area -= j;
        }
        return area;
    }
}

