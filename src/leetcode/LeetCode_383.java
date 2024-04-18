package leetcode;

// 문제 링크: https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
// 383. Ransom Note

// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
// 알고리즘: 파싱

public class LeetCode_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a']--;
        }

        return true;
    }
}
