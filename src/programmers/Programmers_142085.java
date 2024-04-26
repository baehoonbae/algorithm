package programmers;

import java.util.*;

public class Programmers_142085 {
    public int solution(int n, int k, int[] enemy) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            sum += enemy[i];
            if (sum > n) {
                sum -= pq.poll();
                if (k == 0) {
                    return i;
                }
                k--;
            }
        }
        return enemy.length;
    }
}