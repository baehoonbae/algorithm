package programmers;

import java.util.*;

public class Programmers_72413 {

    int N;
    int[][] fee;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        fee = new int[N][N];
        Arrays.stream(fee).forEach(arr -> Arrays.fill(arr, -1));
        for (int[] fare : fares) {
            fee[fare[0] - 1][fare[1] - 1] = fare[2];
            fee[fare[1] - 1][fare[0] - 1] = fare[2];
        }

        int[] together = dijikstra(s - 1);
        int bestCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] alone = dijikstra(i);
            int cost = together[i] + alone[a - 1] + alone[b - 1];
            bestCost = Math.min(bestCost, cost);
        }

        return bestCost;
    }

    public int[] dijikstra(int here) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[here] = 0;
        pq.add(new Pair<>(here, 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            int vertex = current.vertex;
            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;
            for (int i = 0; i < fee[vertex].length; i++) {
                if (fee[vertex][i] == -1) {
                    continue;
                }
                if (distance[vertex] + fee[vertex][i] < distance[i]) {
                    distance[i] = distance[vertex] + fee[vertex][i];
                    pq.add(new Pair<>(i, distance[i]));
                }
            }
        }

        return distance;
    }

    public static class Pair<L, R> {
        L vertex;
        R cost;

        Pair(L vertex, R cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}