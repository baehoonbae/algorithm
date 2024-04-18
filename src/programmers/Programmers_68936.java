package programmers;

public class Programmers_68936 {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        int n = arr.length;
        divide(arr, 0, 0, n);
        return answer;
    }

    public void divide(int[][] arr, int a, int b, int size) {
        if (check(arr, a, b, size)) {
            answer[arr[a][b]]++;
            return;
        }

        int newSize = size / 2;
        divide(arr, a, b, newSize);
        divide(arr, a, b + newSize, newSize);
        divide(arr, a + newSize, b, newSize);
        divide(arr, a + newSize, b + newSize, newSize);
    }

    // 다 같은 숫자인지 확인
    public boolean check(int[][] arr, int a, int b, int size) {
        int temp = arr[a][b];
        for (int i = a; i < a + size; i++) {
            for (int j = b; j < b + size; j++) {
                if (arr[i][j] != temp) {
                    return false;
                }
            }
        }
        return true;
    }
}
