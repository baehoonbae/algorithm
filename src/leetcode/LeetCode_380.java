package leetcode;

import java.util.*;

// 380. Insert Delete GetRandom O(1)

// Runtime: 32 ms
// Memory: 87.22 MB
// Time Complexity: O(1)
// Space Complexity: O(n)

public class LeetCode_380 {
    List<Integer> list;
    public Map<Integer, Integer> m;

    public LeetCode_380() {
        list = new ArrayList<>();
        m = new HashMap<>();
    }

    public boolean insert(int val) {
        if (m.containsKey(val)) {
            return false;
        }
        list.add(val);
        m.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!m.containsKey(val)) {
            return false;
        }

        int index = m.get(val);
        list.set(index, list.getLast());
        m.put(list.get(index), index);

        list.removeLast();
        m.remove(val);

        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */