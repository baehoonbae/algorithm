package programmers;

import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17678
// 프로그래머스 #셔틀버스

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
// 알고리즘: 파싱, 그리디

public class Programmers_17678 {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];
        for (int i = 0; i < times.length; i++) {
            int H = Integer.parseInt(timetable[i].substring(0, 2));
            int M = Integer.parseInt(timetable[i].substring(3, 5));
            times[i] = H * 60 + M;
        }
        Arrays.sort(times);

        int time = 0;
        int idx = 0;
        int bus = 540;
        while (true) {
            // 버스가 도착했을 떄
            int count = 0;
            while (count < m) {
                if (idx >= times.length) {
                    break;
                }
                if (times[idx] <= bus) {
                    idx++;
                } else break;
                count++;
            }
            n--;

            // 막차였을 떄
            if (n == 0) {
                if (idx == 0) {
                    time = bus;
                    break;
                }
                if (count == m) {
                    time = times[idx - 1] - 1;
                    break;
                }
                if (idx == times.length) {
                    time = bus;
                    break;
                } else {
                    time = bus;
                    break;
                }
            }

            bus += t;
        }
        StringBuilder sb = new StringBuilder();
        if (time / 60 < 10) sb.append("0").append(time / 60).append(":");
        else sb.append(time / 60).append(":");

        if (time % 60 < 10) sb.append("0").append(time % 60);
        else sb.append(time % 60);

        return sb.toString();
    }
}