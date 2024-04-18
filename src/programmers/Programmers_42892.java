package programmers;

import java.util.Arrays;
import java.util.Comparator;

// 문제 출처: https://school.programmers.co.kr/learn/courses/30/lessons/42892
// 프로그래머스 길 찾기 게임

// 시간 복잡도: O(nlogn)
// 알고리즘: 트리

public class Programmers_42892 {
    public static class Node {
        Node left;
        Node right;
        int val;
        int x;
        int y;

        public Node(int x, int y, int val, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int[][] answer;
    public static int idx = 0;

    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        Node[] node = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }
        Arrays.sort(node, (n1, n2) -> {
            if (n1.y == n2.y) return n1.x - n2.x;
            else return n2.y - n1.y;
        });
        Node root = node[0];
        for (int i = 1; i < node.length; i++) {
            insert(root, node[i]);
        }
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        return answer;
    }

    public static void insert(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }

    // 전위
    public static void preorder(Node root) {
        if (root != null) {
            answer[0][idx++] = root.val;
            preorder(root.left);
            preorder(root.right);
        }
    }

    // 후위
    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.val;
        }
    }
}
