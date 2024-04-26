package leetcode;

import java.util.Arrays;

// 948. Bag of Tokens

// Runtime: 2 ms
// Memory: 42.72 MB
// TC: O(n log n)
// SC: O(1)

public class LeetCode_948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int idx = tokens.length - 1;
        for (int i = 0; i < tokens.length; i++) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                continue;
            }
            if (idx <= i) break;
            if (power < tokens[i] && score >= 1) {
                power += tokens[idx];
                score--;
                idx--;
                i--;
            }
        }
        return score;
    }
}