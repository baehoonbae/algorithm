package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1439. 뒤집기

public class Baekjoon_1439 {
    public void reverseString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        int oneCount = 0;
        int zeroCount = 0;
        char c = s.charAt(0);
        if (c == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                c = s.charAt(i);
                if (c == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }
        System.out.println(Math.min(oneCount,zeroCount));
    }
}
