package baekjoon;

import java.util.*;

public class Baekjoon_20301 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> d = new LinkedList<>();
        for (int i = 1; i <= n; i++) d.add(i);

        int count = 0;
        int reverseCount = 0;
        boolean reverse = false;

        while (!d.isEmpty()) {
            count++;
            if (count == k) {
                if (!reverse) {
                    sb.append(d.pollFirst()).append('\n');
                } else {
                    sb.append(d.pollLast()).append('\n');
                }
                count = 0;
                reverseCount++;
                if (reverseCount == m) {
                    reverse = !reverse;
                    reverseCount = 0;
                }
                continue;
            }
            if (reverse) {
                d.addFirst(d.pollLast());
            } else {
                d.addLast(d.pollFirst());
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}


