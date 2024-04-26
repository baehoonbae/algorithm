package leetcode;

import java.util.Stack;

// 문제 링크: https://leetcode.com/problems/maximal-rectangle/
// 85. Maximal Rectangle
// 문제 요약: 0과 1로 이루어진 행렬에서 1로 이루어진 직사각형의 최대 넓이를 구하는 문제.

// 알고리즘: Monotonic Stack
// 시간 복잡도: O(M * N^2)
// 공간 복잡도: O(N)

// 풀이
// 1. 각 행 별로 높이가 더해지는 히스토그램 배열을 만들어서 그 배열 안에서 가능한 직사각형 넓이의 경우의 수를 구해야 한다.
// 2. 히스토그램 배열을 만들기 위해 각 행을 순회하면서 1이 나오면 높이를 더하고, 0이 나오면 높이를 0으로 초기화한다.
// 3. 직사각형 넓이의 경우의 수는 스택을 이용하여 구할 수 있다.
// 4. 스택에는 인덱스를 저장하며, 스택의 top이 가리키는 높이보다 현재 높이가 작을 때까지 pop하면서 넓이를 구한다.
// 5. while 문에서는 오름차순으로 저장되었던 높이들을 내림차순으로 빼내면서(이때 가로 길이는 계속 1씩 증가하는 형태) 최대 넓이를 계속 갱신하는 방식이다.
// 6. 최대 넓이를 반환한다.

public class LeetCode_85 {
    public int largestRectangleArea(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < histogram.length; i++) {
            while (stack.peek() != -1 && histogram[stack.peek()] >= histogram[i]) {
                int height = histogram[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = histogram[stack.pop()];
            int width = histogram.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] histogram = new int[matrix[0].length];

        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == '1') {
                    histogram[j]++;
                } else {
                    histogram[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(histogram));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LeetCode_85 s = new LeetCode_85();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(s.maximalRectangle(matrix)); // 6
    }
}
