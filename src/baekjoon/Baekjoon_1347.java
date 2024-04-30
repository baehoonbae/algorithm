package baekjoon;

import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/1347
// 1347. 미로 만들기
// 문제 요약: 주어진 문자열에 따라 이동하면서 만들어지는 미로를 출력하는 문제.

// 알고리즘: 구현, 시뮬레이션
// 시간 복잡도: O(N^2)
// 공간 복잡도: O(N^2)

// 풀이
// 1. 배열의 크기를 위, 아래로 한칸씩 늘려가면서 만들어진 배열을 주어진 명령어에 따라 이동하는 반복문 생성
// 2. 이동할 수 있는 공간이라면 좌표를 스택에 저장해놓고, 이동할 수 없는 경우에는 스택을 비우고 다음 좌표에서 다시 시작
// 3. 주어진 문자열을 모두 순회했다면 반복문을 모두 종료한다
// 4. 스택에 저장되어 있는 좌표는 '.' 으로 표시하고, 아닌 부분은 '#' 으로 표시한다.
// 5. '.' 이 저장되어 있는 최대 y 좌표와 x 좌표만을 찾아서 그 범위에 해당하는 부분을 출력한다

public class Baekjoon_1347 {
    // 오른쪽: +
    // 왼쪽: -
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String commands = sc.nextLine();
        List<List<Character>> arr = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            arr.add(new ArrayList<>());
            for (int j = 0; j < 2; j++) {
                arr.get(i).add('?');
            }
        }
        Stack<Integer[]> stack = new Stack<>();
        while (true) {
            boolean check = false;
            int ySize = arr.size();
            int xSize = arr.get(0).size();
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    check = false;
                    int y = i, x = j, idx = 0;
                    stack.push(new Integer[]{y, x});
                    for (char c : commands.toCharArray()) {
                        if (c == 'R') {
                            idx++;
                            idx %= 4;
                        } else if (c == 'L') {
                            idx--;
                            if (idx < 0) idx += 4;
                        } else {
                            y += dy[idx];
                            x += dx[idx];
                            stack.push(new Integer[]{y, x});
                            if (y < 0 || x < 0 || y > ySize - 1 || x > xSize - 1) {
                                stack.removeAllElements();
                                check = true;
                                break;
                            }
                        }
                    }
                    if (!check) break;
                }
                if (!check) break;
            }
            if (!check) break;
            arr.add(new ArrayList<>());
            for (int i = 0; i < arr.size(); i++) {
                arr.get(i).add('?');
            }
        }
        int maxY = 0, maxX = 0;
        char[][] result = new char[arr.size()][arr.get(0).size()];
        while (!stack.isEmpty()) {
            result[stack.peek()[0]][stack.pop()[1]] = '.';
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = '#';
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == '.') {
                    maxY = Math.max(maxY, i + 1);
                    maxX = Math.max(maxX, j + 1);
                }
            }
        }
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }
}
