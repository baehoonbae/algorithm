package programmers;

import java.util.Arrays;

public class Programmers_49191 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            arr[results[i][0]][results[i][1]] = 1;
            arr[results[i][1]][results[i][0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (arr[i][j] == 1 && arr[j][k] == 1) {
                        arr[i][k] = 1;
                        arr[k][i] = -1;
                    }
                    if (arr[i][j] == -1 && arr[j][k] == -1) {
                        arr[i][k] = -1;
                        arr[k][i] = 1;
                    }

                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != 0) count++;
            }
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
