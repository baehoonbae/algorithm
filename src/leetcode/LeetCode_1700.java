package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
// 1700. Number of Students Unable to Eat Lunch
// 문제 요약: 학생들이 선호하는 샌드위치를 먹을 수 있는지 확인하는 문제. 샌드위치를 먹을 수 없는 학생의 수를 반환.

// 알고리즘: 큐, 구현
// 시간 복잡도: O(n) (n은 학생의 수)
// 공간 복잡도: O(n)

// 풀이
// 1. 학생을 순서대로 큐에 넣어준다.
// 2. 샌드위치를 순서대로 확인하면서 학생이 선호하는 샌드위치인 경우 큐에서 빼주고 인덱스를 증가시켜 준다.
// 3. 만약 학생이 선호하는 샌드위치가 아닌 경우 다시 큐에 넣어주고 count를 증가시켜 준다(이때 count는 먹지 못한 학생의 수이다).
// 4. 만약 count가 큐의 크기와 같아진다면, 학생들이 모두 같은 종류의 샌드위치를 원하는 상태인 것이다.
// 5. 즉 더 이상 샌드위치를 먹을 수 없는 학생이 남아있는 것이므로 count를 반환해준다.

public class LeetCode_1700 {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();

        for (int student : students) {
            q.add(student);
        }

        int i = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int student = q.poll();
            if (student == sandwiches[i]) {
                i++;
                count = 0;
            } else {
                q.add(student);
                count++;
                if (count == q.size()) {
                    break;
                }
            }
        }
        return q.size();
    }

    public static void main(String[] args) {
        countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1});
    }

}
