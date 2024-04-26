package programmers;

public class Programmers_77485 {
    public static int[][] arr;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        int num = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num;
                num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int y1 = queries[i][0] - 1;
            int x1 = queries[i][1] - 1;
            int y2 = queries[i][2] - 1;
            int x2 = queries[i][3] - 1;
            answer[i] = rotate(x1, x2, y1, y2);
        }

        return answer;
    }

    public int rotate(int x1, int x2, int y1, int y2) {
        int minValue = arr[y1][x1];
        int temp = arr[y1][x1];
        int x;
        int y = y1;
        for (x = x1 + 1; x <= x2; x++) {
            int t = arr[y][x];
            arr[y][x] = temp;
            temp = t;
            minValue = Math.min(minValue, arr[y1][x]);
        }
        x = x2;
        for (y = y1 + 1; y <= y2; y++) {
            int t = arr[y][x];
            arr[y][x] = temp;
            temp = t;
            minValue = Math.min(minValue, arr[y][x]);
        }
        y = y2;
        for (x = x2 - 1; x >= x1; x--) {
            int t = arr[y][x];
            arr[y][x] = temp;
            temp = t;
            minValue = Math.min(minValue, arr[y][x]);
        }
        x = x1;
        for (y = y2 - 1; y >= y1; y--) {
            int t = arr[y][x];
            arr[y][x] = temp;
            temp = t;
            minValue = Math.min(minValue, arr[y][x]);
        }

        return minValue;
    }
}