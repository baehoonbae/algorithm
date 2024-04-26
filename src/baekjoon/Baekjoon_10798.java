package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10798. 세로읽기

public class Baekjoon_10798 {
    public static void main(String[] args) throws IOException {
        char[][] arr = new char[5][15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == '\0') {
                    continue;
                }
                System.out.print(arr[j][i]);
            }
        }
    }
}