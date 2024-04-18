package leetcode;

// 1642. Furthest Building You Can Reach

// Runtime: 15 ms
// Memory: 59.75 MB

// Time Complexity: O(nlogk)
// Space Complexity: O(min(n,ladders))

import java.util.*;

public class LeetCode_1642 {
    public int furthestBuilding(int[] h, int bricks, int ladders) {
        int i = 0;
        int diff = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        for (i = 0; i < h.length - 1; i++) {
            diff = h[i + 1] - h[i];
            if (diff <= 0) {
                continue;
            }
            bricks -= diff;
            p.offer(diff);
            if (bricks < 0) {
                bricks += p.poll();
                ladders--;
            }
            if (ladders < 0) {
                break;
            }
        }
        return i;
    }
}

