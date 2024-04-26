package programmers;

import java.util.*;

public class Programmers_131130 {
    public int solution(int[] cards) {
        int[] result = new int[cards.length];
        Arrays.fill(result, 0);
        for (int i = 0; i < cards.length; i++) {
            int idx = cards[i] - 1;
            int count = 0;
            if (cards[i] == -1) {
                continue;
            }
            count++;
            cards[i] = -1;
            while (cards[idx] != -1) {
                int temp = cards[idx] - 1;
                cards[idx] = -1;
                idx = temp;
                count++;
            }
            if (count != 0) {
                result[i] = count;
            }
        }
        Arrays.sort(result);
        if (result[cards.length - 2] == 0) {
            return 0;
        }
        return result[cards.length - 1] * result[cards.length - 2];
    }
}
