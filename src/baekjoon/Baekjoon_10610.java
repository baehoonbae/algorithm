package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 10610. 30

public class Baekjoon_10610 {
    public static void thirty() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = new char[100001];
        String str = br.readLine();
        int sum = 0;

        if (!str.contains("0")) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }
            if ((sum * 10) % 30==0) {
                arr = str.toCharArray();
                Arrays.sort(arr);
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.print(arr[i]);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}

