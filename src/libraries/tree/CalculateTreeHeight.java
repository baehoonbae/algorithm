package libraries.tree;

public class CalculateTreeHeight {
    public int calculateTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calculateTreeHeight(root.left), calculateTreeHeight(root.right));
    }
}