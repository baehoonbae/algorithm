package leetcode;

// 문제 링크: https://leetcode.com/problems/word-search/
// 79. Word Search
// 문제 요약: 주어진 2차원 보드에서, 주어진 문자열이 순서에 맞게 존재하는지 확인하는 문제.
// 알고리즘 분류: DFS, 백트래킹, 재귀

// 풀이
// 1. 주어진 문자열의 첫 글자를 찾아서 해당 위치에서 DFS 탐색을 시작함.
// 2. DFS 탐색을 진행하면서 주어진 문자열의 길이만큼 탐색이 완료되면 true를 반환하고 종료.
// 3. 탐색 중에 범위를 벗어나거나 이미 방문한 곳이거나, 문자가 일치하지 않는 경우 false를 반환하고 종료.
// 4. 탐색이 끝나면 해당 위치를 다시 방문하지 않도록 false로 변경해주고 이전 위치에서 다시 탐색 진행.

public class LeetCode_79 {
    boolean[][] isVisited;
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        isVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = dfs(i, j, board, word, 0);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || isVisited[i][j]
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        isVisited[i][j] = true;
        if (dfs(i + 1, j, board, word, index + 1) ||
            dfs(i - 1, j, board, word, index + 1) ||
            dfs(i, j + 1, board, word, index + 1) ||
            dfs(i, j - 1, board, word, index + 1)) {
            return true;
        }
        isVisited[i][j] = false;
        return false;
    }
}

