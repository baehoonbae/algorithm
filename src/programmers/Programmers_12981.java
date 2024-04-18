package programmers;

import java.util.*;

public class Programmers_12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Map<String, Boolean> eng = new HashMap<>();
        eng.put(words[0], true);

        for (int i = 1; i < words.length; i++) {
            if (Boolean.TRUE.equals(eng.get(words[i])) || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                answer[0] = i % n + 1; // 자기 번호
                answer[1] = i / n + 1; // 몇 번째 차례?
                return answer;
            }
            eng.put(words[i], true);
        }

        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}
