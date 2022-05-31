public class code_045_二叉树最底层最左边的值 {
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
        private int result;
        private int depth = -1;

        public int findBottomLeftValue(TreeNode root) {
            traversal(root, 0);
            return result;
        }

        private void traversal(TreeNode node, int index) {
            if (index > depth) {
                depth = index;
                result = node.val;
            }
            if (node.left != null) traversal(node.left, index + 1);
            if (node.right != null) traversal(node.right, index + 1);
        }
    }
}
