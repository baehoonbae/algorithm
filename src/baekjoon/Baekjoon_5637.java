package baekjoon;

import java.util.*;

// 문제 링크: https://www.acmicpc.net/problem/5637
// 5637. 가장 긴 단어
// 문제: 문장이 주어지면, 가장 긴 단어를 찾아 소문자로 출력하라.

// 알고리즘: 문자열, 구현
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. 문장을 입력받아 공백을 기준으로 단어를 나눈다.
// 2. 각 단어를 순회하면서 알파벳 또는 '-'인 경우 temp에 추가한다.
// 3. temp의 길이가 maxLength보다 길면 maxLength와 answer를 갱신한다.
// 4. answer를 소문자로 출력한다.

public class Baekjoon_5637 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        String answer = "";
        int maxLength = 0;

        while (true) {
            String temp = sc.nextLine();
            if (temp.contains("E-N-D")) {
                s += temp.substring(0, temp.indexOf("E-N-D"));
                break;
            }
            s += temp;
            s += " ";
        }

        String[] strs = s.split(" ");

        for (String string : strs) {
            String temp = "";
            for (int j = 0; j < string.length(); j++) {
                char c = string.charAt(j);
                if (Character.isLetter(c) || c == '-') {
                    temp += c;
                }
            }
            if (maxLength < temp.length()) {
                maxLength = temp.length();
                answer = temp.toLowerCase();
            }
        }
        System.out.println(answer);
    }
}
