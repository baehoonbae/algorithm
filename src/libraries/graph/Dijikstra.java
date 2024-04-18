package libraries.graph;

import libraries.pairs.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijikstra {
    int[][] arr = new int[6][6];

    public int[] dijikstra(int here) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        boolean[] visited = new boolean[arr.length];
        int[] distance = new int[arr.length];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[here] = 0;
        pq.add(new Pair<>(here, 0));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            int vertex = current.first;
            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;

            for (int i = 0; i < arr[vertex].length; i++) {
                if (arr[vertex][i] == -1) {
                    continue;
                }

                if (distance[vertex] + arr[vertex][i] < distance[i]) {
                    distance[i] = distance[vertex] + arr[vertex][i];
                    pq.add(new Pair<>(i, distance[i]));
                }
            }
        }

        return distance;
    }
}

