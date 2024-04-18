package leetcode;

import java.util.Arrays;

// 274. H-Index

// Runtime: 2 ms
// Memory: 41.29 MB
// Time Complexity: O(n)
// Space Complexity: O(1)

public class LeetCode_274 {
    public int hIndex(int[] citations) {

        int maxH = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (maxH <= citations[i]) {
                maxH++;
            }
        }
        return maxH;
    }
}
