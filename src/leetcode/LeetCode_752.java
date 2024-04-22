package leetcode;

import java.util.*;

// 문제 링크: https://leetcode.com/problems/open-the-lock/
// 752. Open the Lock
// 문제 요약: 0000부터 시작해서 target을 찾을 때까지 4자리 숫자를 돌리는데, deadends에 있는 숫자는 돌릴 수 없다.

// 알고리즘: 양방향 탐색
// 시간 복잡도: O(10000)
// 공간 복잡도: O(10000)

// 풀이
// 1. 시작점과 끝점에서 양방향으로 BFS 탐색을 진행한다.
// 2. visited 배열을 통해 방문한 노드를 체크하고, deadends 배열을 통해 방문할 수 없는 노드를 체크한다.
// 3. forward 와 backward 두 큐를 이용해, 각 단계에서 더 작은 큐를 먼저 처리한다.
// 4. 이때 서로 만나게 되는 지점이 최소 회전 횟수가 된다(반드시 최단 경로가 됨).

public class LeetCode_752 {
    public int openLock(String[] deadends, String target) {
        // -1: visited through backward direction, 0: not visited, 1: visited through forward direction, 2: deadend,
        int[] visited = new int[10000];
        int[] pow10 = {1, 10, 100, 1000};
        for (String deadend : deadends) {
            visited[Integer.parseInt(deadend)] = 2;
        }
        int src = 0, dest = Integer.parseInt(target), rotate = 0, dir = 1;
        if (visited[src] == 2 || visited[dest] == 2) return -1;
        if (src == dest) return 0;

        Queue<Integer> forward = new LinkedList<>(), backward = new LinkedList<>();
        forward.add(src);
        backward.add(dest);
        visited[src] = 1;
        visited[dest] = -1;

        while (!forward.isEmpty() && !backward.isEmpty()) {
            if (forward.size() > backward.size()) {
                Queue<Integer> temp = forward;
                forward = backward;
                backward = temp;
                dir = -dir;
            }
            rotate++;
            int size = forward.size();
            while (size-- > 0) {
                int current = forward.poll();
                for (int p : pow10) {
                    int d = (current / p) % 10;
                    for (int i = -1; i <= 1; i += 2) {
                        int z = d + i;
                        z = z == -1 ? 9 : (z == 10 ? 0 : z);
                        int next = current + (z - d) * p;
                        if (visited[next] == -dir) {
                            return rotate;
                        }
                        if (visited[next] == 0) {
                            forward.add(next);
                            visited[next] = dir;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_752 solution = new LeetCode_752();
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        System.out.println(solution.openLock(deadends, target));
    }
}
