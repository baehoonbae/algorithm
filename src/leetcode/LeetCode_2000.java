package leetcode;

// 문제 링크: https://leetcode.com/problems/reverse-prefix-of-word/
// 2000. Reverse Prefix of Word
// 문제 요약: 문자열 word와 문자 ch가 주어지면, word에서 ch가 처음 나오는 위치까지의 문자열을 뒤집은 결과를 반환하는 문제.

// 알고리즘: 문자열
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)

// 풀이
// 1. word에서 ch가 처음 나오는 위치를 찾는다.
// 2. ch가 -1 이라면 word 에 ch 가 없다는 뜻이므로 word 를 그대로 반환한다.
// 3. ch가 있는 위치까지의 문자열을 뒤집은 후(StringBuilder 사용), ch가 있는 위치부터 끝까지의 문자열을 붙여서 반환한다.

public class LeetCode_2000 {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) return word;
        StringBuilder sb = new StringBuilder(word.substring(0, idx + 1));
        sb = sb.reverse();
        sb.append(word.substring(idx + 1));
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
