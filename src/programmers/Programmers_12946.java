package programmers;

import java.util.*;

public class Programmers_12946 {
    public static List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer = new int[list.size()][2];
        move(n, 1, 2, 3);
        answer = list.stream().toArray(int[][]::new);
        return answer;
    }

    public void move(int cnt, int start, int mid, int end) {
        move(cnt - 1, start, end, mid);
        list.add(new int[]{start, end});
        move(cnt - 1, mid, start, end);
    }
}