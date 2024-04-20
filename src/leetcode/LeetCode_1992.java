package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/find-latest-group-of-size-m/
// 1992. Find All Groups of Farmland
// 문제 요약: 2차원 배열에서 1로 이어져 있는 땅의 영역들의 시작 지점과 끝 지점을 배열로 반환하는 문제

// 알고리즘: 구현, DFS
// 시간 복잡도: O(m * n)
// 공간 복잡도: O(1)

// 풀이
// 1. 2차원 배열을 순회하면서 1을 만나면 해당 위치가 땅의 시작 지점인지 확인
// 2. 시작 지점이라면 오른쪽과 아래쪽으로 이동하면서 땅의 끝 지점을 찾음
// 3. 땅의 시작 지점과 끝 지점을 리스트에 추가
// 4. 모든 땅의 시작 지점과 끝 지점을 2차원 배열로 반환

public class LeetCode_1992 {
    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0 || (j > 0 && land[i][j - 1] == 1) || (i > 0 && land[i - 1][j] == 1)) {
                    continue;
                }
                int x = j;
                int y = i;
                while (x + 1 < land[0].length && land[i][x + 1] == 1) {
                    x++;
                }
                while (y + 1 < land.length && land[y + 1][j] == 1) {
                    y++;
                }
                list.add(new int[] { i, j, y, x });
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        LeetCode_1992 leetCode_1992 = new LeetCode_1992();
        int[][] land = {{1,1,1,1,1,1,1,1,1,1,1,1}};
        int[][] result = leetCode_1992.findFarmland(land);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
