import java.util.ArrayList;
import java.util.List;

public class code_046_二叉树的右侧视图 {
    public static void main(String[] args) {
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        private final List<Integer> result = new ArrayList<>();
        private int depth = -1;

        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return result;
            traversal(root, 0);
            return result;
        }

        private void traversal(TreeNode node, int index) {
            if (index > depth) {
                depth = index;
                result.add(node.val);
            }
            if (node.right != null) traversal(node.right, index + 1);
            if (node.left != null) traversal(node.left, index + 1);
        }
    }
}
